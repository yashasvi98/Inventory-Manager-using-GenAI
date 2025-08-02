package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

/**
 * JPA entity representing a low stock alert for an item.
 */
@Entity
@Table(name="low_stock_alerts")
@Data
@NoArgsConstructor
@Builder
public class LowStockAlert {
    /** Primary key for the alert. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Item ID associated with the alert. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Stock threshold that triggers the alert. */
    @Column(nullable=false)
    private Integer threshold;

    /** Timestamp when the alert was triggered. */
    @Column(name="triggered_at", nullable=false)
    private Instant triggeredAt = Instant.now();

    /** Whether the alert has been notified. */
    @Column(nullable=false)
    private Boolean notified = false;
}
