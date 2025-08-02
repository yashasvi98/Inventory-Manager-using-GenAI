package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for supplier response data.
 */
@Data
@Builder
public class SupplierResponse {
    /** Unique identifier for the supplier. */
    private Long id;
    /** Name of the supplier. */
    private String name;
    /** Contact email for the supplier. */
    private String contact;
}
