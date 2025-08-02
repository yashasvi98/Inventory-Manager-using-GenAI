package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * JPA entity representing a product category.
 */
@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@Builder
public class Category {
    /** Primary key for the category. */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Name of the category (unique). */
    @Column(nullable=false, unique=true, length=100)
    private String name;
}
