package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * JPA entity representing a supplier.
 */
@Entity
@Table(name="suppliers")
@Data
@NoArgsConstructor
@Builder
public class Supplier {
    /** Primary key for the supplier. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Name of the supplier. */
    @Column(nullable=false, length=255)
    private String name;

    /** Contact email for the supplier. */
    @Column(length=255)
    private String contact;
}
