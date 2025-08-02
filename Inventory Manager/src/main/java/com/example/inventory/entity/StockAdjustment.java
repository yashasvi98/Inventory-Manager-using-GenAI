package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

/**
 * JPA entity representing a stock adjustment for an item.
 */
@Entity
@Table(name="stock_adjustments")
@Data
@NoArgsConstructor
@Builder
public class StockAdjustment {
    /** Primary key for the stock adjustment. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Item ID for which the stock was adjusted. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Quantity adjusted (positive or negative). */
    @Column(nullable=false)
    private Integer quantity;

    /** Reason for adjustment (RECEIPT, SALE, LOSS). */
    @Column(nullable=false, length=20)
    private String reason;

    /** Timestamp when the adjustment was made. */
    @Column(name="adjusted_at", nullable=false)
    private Instant adjustedAt = Instant.now();

    /** User ID who performed the adjustment. */
    @Column(name="adjusted_by", nullable=false)
    private Long adjustedBy;
}
