package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

/**
 * JPA entity representing an inventory item.
 */
@Entity
@Table(name="items")
@Data
@NoArgsConstructor
@Builder
public class Item {
    /** Primary key for the item. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Name of the item. */
    @Column(nullable=false, length=255)
    private String name;

    /** Optional description of the item. */
    @Column(columnDefinition="TEXT")
    private String description;

    /** Unique SKU (Stock Keeping Unit) for the item. */
    @Column(nullable=false, unique=true, length=100)
    private String sku;

    /** Category ID the item belongs to. */
    @Column(name="category_id", nullable=false)
    private Long categoryId;

    /** Supplier ID for the item. */
    @Column(name="supplier_id", nullable=false)
    private Long supplierId;

    /** Timestamp when the item was created. */
    @Column(name="created_at", nullable=false, updatable=false)
    private Instant createdAt = Instant.now();

    /** Timestamp when the item was last updated. */
    @Column(name="updated_at", nullable=false)
    private Instant updatedAt = Instant.now();
}
