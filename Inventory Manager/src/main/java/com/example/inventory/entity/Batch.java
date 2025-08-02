package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * JPA entity representing a batch of inventory.
 */
@Entity
@Table(name="batches")
@Data
@NoArgsConstructor
@Builder
public class Batch {
    /** Primary key for the batch. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Item ID the batch belongs to. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Unique batch number. */
    @Column(name="batch_number", nullable=false, length=50)
    private String batchNumber;

    /** Expiry date for the batch. */
    @Column(name="expiry_date", nullable=false)
    private LocalDate expiryDate;

    /** Quantity in the batch. */
    @Column(nullable=false)
    private Integer quantity;
}
