package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * DTO for reservation response data.
 */
@Data
@Builder
public class ReservationResponse {
    /** Unique identifier for the reservation. */
    private Long id;
    /** Order ID for which the reservation is made. */
    private Long orderId;
    /** Item ID reserved. */
    private Long itemId;
    /** Quantity reserved. */
    private Integer quantity;
    /** Reservation status. */
    private String status;
    /** Timestamp when the reservation was made. */
    private Instant reservedAt;
    /** Timestamp when the reservation expires. */
    private Instant expiresAt;
}
