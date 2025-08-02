package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

/**
 * JPA entity representing a transfer of inventory between warehouses.
 */
@Entity
@Table(name="transfers")
@Data
@NoArgsConstructor
@Builder
public class Transfer {
    /** Primary key for the transfer. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Item ID transferred. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Source warehouse ID. */
    @Column(name="from_warehouse_id", nullable=false)
    private Long fromWarehouseId;

    /** Destination warehouse ID. */
    @Column(name="to_warehouse_id", nullable=false)
    private Long toWarehouseId;

    /** Quantity transferred. */
    @Column(nullable=false)
    private Integer quantity;

    /** Timestamp when the transfer occurred. */
    @Column(name="transfer_date", nullable=false)
    private Instant transferDate = Instant.now();

    /** User ID who created the transfer. */
    @Column(name="created_by", nullable=false)
    private Long createdBy;
}
