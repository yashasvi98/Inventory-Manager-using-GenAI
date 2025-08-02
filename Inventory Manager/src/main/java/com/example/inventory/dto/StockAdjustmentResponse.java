package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * DTO for stock adjustment response data.
 */
@Data
@Builder
public class StockAdjustmentResponse {
    /** Unique identifier for the stock adjustment. */
    private Long id;
    /** Item ID for which the stock was adjusted. */
    private Long itemId;
    /** Quantity adjusted (positive or negative). */
    private Integer quantity;
    /** Reason for adjustment. */
    private String reason;
    /** Timestamp when the adjustment was made. */
    private Instant adjustedAt;
    /** User ID who performed the adjustment. */
    private Long adjustedBy;
}
