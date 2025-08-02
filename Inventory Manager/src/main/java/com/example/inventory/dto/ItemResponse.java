package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * DTO for item response data.
 */
@Data
@Builder
public class ItemResponse {
    /** Unique identifier for the item. */
    private Long id;
    /** Name of the item. */
    private String name;
    /** Optional description of the item. */
    private String description;
    /** SKU (Stock Keeping Unit) of the item. */
    private String sku;
    /** Category ID the item belongs to. */
    private Long categoryId;
    /** Supplier ID for the item. */
    private Long supplierId;
    /** Timestamp when the item was created. */
    private Instant createdAt;
    /** Timestamp when the item was last updated. */
    private Instant updatedAt;
}
