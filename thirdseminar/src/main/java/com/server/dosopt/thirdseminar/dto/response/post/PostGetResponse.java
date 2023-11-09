package com.server.dosopt.thirdseminar.dto.response.post;

import com.server.dosopt.thirdseminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content
) {
    public static PostGetResponse of(Post post) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }
}