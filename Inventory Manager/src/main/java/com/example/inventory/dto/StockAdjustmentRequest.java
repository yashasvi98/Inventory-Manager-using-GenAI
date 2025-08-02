package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for stock adjustment requests.
 */
@Data
public class StockAdjustmentRequest {
    /** Item ID for which the stock is adjusted. */
    @NotNull
    private Long itemId;

    /** Quantity to adjust (positive or negative). */
    @NotNull
    private Integer quantity;

    /** Reason for adjustment (RECEIPT, SALE, LOSS). */
    @NotNull
    @Pattern(regexp = "RECEIPT|SALE|LOSS")
    private String reason;

    /** User ID who performed the adjustment. */
    @NotNull
    private Long adjustedBy;
}
