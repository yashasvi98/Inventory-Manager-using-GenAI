package com.example.inventory.mapper;

import com.example.inventory.dto.CategoryRequest;
import com.example.inventory.dto.CategoryResponse;
import com.example.inventory.entity.Category;

public final class CategoryMapper {
    private CategoryMapper() {}

    /**
     * Converts a CategoryRequest DTO to a Category entity.
     */
    public static Category toEntity(CategoryRequest req) {
        Category c = new Category();
        c.setName(req.getName());
        return c;
    }

    /**
     * Converts a Category entity to a CategoryResponse DTO.
     */
    public static CategoryResponse toResponse(Category c) {
        return CategoryResponse.builder()
            .id(c.getId())
            .name(c.getName())
            .build();
    }
}
