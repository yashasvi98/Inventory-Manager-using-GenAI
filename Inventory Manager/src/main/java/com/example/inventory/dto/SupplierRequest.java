package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for supplier creation requests.
 */
@Data
public class SupplierRequest {
    /** Name of the supplier. */
    @NotBlank
    @Size(max = 255)
    private String name;

    /** Contact email for the supplier. */
    @Email
    private String contact;
}
