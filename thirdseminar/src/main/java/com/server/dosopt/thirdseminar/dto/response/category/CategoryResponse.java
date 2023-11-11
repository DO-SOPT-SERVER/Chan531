package com.server.dosopt.thirdseminar.dto.response.category;

import com.server.dosopt.thirdseminar.domain.Category;

public record CategoryResponse(
        Short id,
        String content
) {
    public static CategoryResponse of (Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getContent()
        );
    }
}