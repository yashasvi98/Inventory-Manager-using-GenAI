package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for transfer creation requests.
 */
@Data
public class TransferRequest {
    /** Item ID to transfer. */
    @NotNull
    @Min(1)
    private Long itemId;

    /** Source warehouse ID. */
    @NotNull
    @Min(1)
    private Long fromWarehouseId;

    /** Destination warehouse ID. */
    @NotNull
    @Min(1)
    private Long toWarehouseId;

    /** Quantity to transfer. */
    @NotNull
    @Min(1)
    private Integer quantity;
}
