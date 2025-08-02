package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

/**
 * JPA entity representing a reservation for an item.
 */
@Entity
@Table(name="reservations")
@Data
@NoArgsConstructor
@Builder
public class Reservation {
    /** Primary key for the reservation. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Order ID for which the reservation is made. */
    @Column(name="order_id", nullable=false)
    private Long orderId;

    /** Item ID reserved. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Quantity reserved. */
    @Column(nullable=false)
    private Integer quantity;

    /** Reservation status. */
    @Column(nullable=false, length=20)
    private String status;

    /** Timestamp when the reservation was made. */
    @Column(name="reserved_at", nullable=false)
    private Instant reservedAt = Instant.now();

    /** Timestamp when the reservation expires. */
    @Column(name="expires_at")
    private Instant expiresAt;
}
