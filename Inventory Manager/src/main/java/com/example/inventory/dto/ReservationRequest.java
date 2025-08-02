package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for reservation creation requests.
 */
@Data
public class ReservationRequest {
    /** Order ID for which the reservation is made. */
    @NotNull
    private Long orderId;

    /** Item ID to reserve. */
    @NotNull
    @Min(1)
    private Long itemId;

    /** Quantity to reserve. */
    @NotNull
    @Min(1)
    private Integer quantity;
}
