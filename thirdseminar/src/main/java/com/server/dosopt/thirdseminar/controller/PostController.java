package com.server.dosopt.thirdseminar.controller;

import com.server.dosopt.thirdseminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.thirdseminar.dto.request.post.PostUpdateRequest;
import com.server.dosopt.thirdseminar.dto.response.post.PostGetResponse;
import com.server.dosopt.thirdseminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostCreateRequest request, Principal principal) {
        Long memberId = Long.valueOf(principal.getName());
        URI location = URI.create("/api/posts/" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}
