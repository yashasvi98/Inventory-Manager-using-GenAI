package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for item creation and update requests.
 */
@Data
public class ItemRequest {
    /** Name of the item. */
    @NotBlank
    @Size(max = 255)
    private String name;

    /** Optional description of the item. */
    private String description;

    /** Unique SKU (Stock Keeping Unit) for the item. */
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[A-Za-z0-9\-]+$")
    private String sku;

    /** Category ID the item belongs to. */
    @NotNull
    private Long categoryId;

    /** Supplier ID for the item. */
    @NotNull
    private Long supplierId;
}
