package com.server.dosopt.thirdseminar.repository;

import com.server.dosopt.thirdseminar.domain.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    default Post findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 게시물입니다."));
    }

    List<Post> findAllByMemberId(Long memberId);
}