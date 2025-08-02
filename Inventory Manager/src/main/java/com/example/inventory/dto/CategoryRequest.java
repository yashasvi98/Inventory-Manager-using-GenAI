package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for category creation requests.
 */
@Data
public class CategoryRequest {
    /** Name of the category. */
    @NotBlank
    @Size(max = 100)
    private String name;
}
