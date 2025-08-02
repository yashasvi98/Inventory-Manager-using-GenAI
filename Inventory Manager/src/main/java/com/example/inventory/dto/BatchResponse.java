package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO for batch response data.
 */
@Data
@Builder
public class BatchResponse {
    /**
     * Unique identifier for the batch.
     */
    private Long id;
    /**
     * Identifier for the item in the batch.
     */
    private Long itemId;
    /**
     * Unique batch number.
     */
    private String batchNumber;
    /**
     * Expiry date for the batch.
     */
    private LocalDate expiryDate;
    /**
     * Quantity of items in the batch.
     */
    private Integer quantity;
}
