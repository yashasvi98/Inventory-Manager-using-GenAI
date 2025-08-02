package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * JPA entity representing an item location in a warehouse.
 */
@Entity
@Table(name="locations")
@Data
@NoArgsConstructor
@Builder
public class Location {
    /** Primary key for the location. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Item ID assigned to the location. */
    @Column(name="item_id", nullable=false)
    private Long itemId;

    /** Warehouse ID where the item is stored. */
    @Column(name="warehouse_id", nullable=false)
    private Long warehouseId;

    /** Warehouse zone. */
    @Column(length=50, nullable=false)
    private String zone;

    /** Bin within the warehouse zone. */
    @Column(length=50, nullable=false)
    private String bin;
}
