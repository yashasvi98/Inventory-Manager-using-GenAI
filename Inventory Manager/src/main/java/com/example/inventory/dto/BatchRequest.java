package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO for batch creation requests.
 */
@Data
public class BatchRequest {
    /** Item ID the batch belongs to. */
    @NotNull
    private Long itemId;

    /** Unique batch number. */
    @NotBlank
    private String batchNumber;

    /** Expiry date for the batch. */
    @NotNull
    private LocalDate expiryDate;

    /** Quantity in the batch. */
    @NotNull
    @Min(0)
    private Integer quantity;
}
