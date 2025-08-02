package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * DTO for transfer response data.
 */
@Data
@Builder
public class TransferResponse {
    /** Unique identifier for the transfer. */
    private Long id;
    /** Item ID transferred. */
    private Long itemId;
    /** Source warehouse ID. */
    private Long fromWarehouseId;
    /** Destination warehouse ID. */
    private Long toWarehouseId;
    /** Quantity transferred. */
    private Integer quantity;
    /** Timestamp when the transfer occurred. */
    private Instant transferDate;
}
