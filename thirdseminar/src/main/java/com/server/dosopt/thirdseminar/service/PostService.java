package com.server.dosopt.thirdseminar.service;

import com.server.dosopt.thirdseminar.domain.Category;
import com.server.dosopt.thirdseminar.domain.Member;
import com.server.dosopt.thirdseminar.domain.Post;
import com.server.dosopt.thirdseminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.thirdseminar.dto.request.post.PostUpdateRequest;
import com.server.dosopt.thirdseminar.dto.response.post.PostGetResponse;
import com.server.dosopt.thirdseminar.repository.MemberJpaRepository;
import com.server.dosopt.thirdseminar.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryService categoryService;

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findByIdOrThrow(postId);
        return PostGetResponse.of(post, getCategoryByPost(post));
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
                .toList();
    }

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        memberJpaRepository.findByIdOrThrow(memberId);
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .build();
        Post savedPost = postJpaRepository.save(post);
        return savedPost.getId().toString();
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findByIdOrThrow(postId);
        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId) {
        postJpaRepository.deleteById(postId);
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }
}