package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for category response data.
 */
@Data
@Builder
public class CategoryResponse {
    /** Unique identifier for the category. */
    private Long id;
    /** Name of the category. */
    private String name;
}
