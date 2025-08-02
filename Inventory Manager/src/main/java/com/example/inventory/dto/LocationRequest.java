package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO for location assignment requests.
 */
@Data
public class LocationRequest {
    /** Item ID to assign a location for. */
    @NotNull
    @Min(1)
    private Long itemId;

    /** Warehouse ID where the item is stored. */
    @NotNull
    @Min(1)
    private Long warehouseId;

    /** Warehouse zone. */
    @NotBlank
    @Size(max = 50)
    private String zone;

    /** Bin within the warehouse zone. */
    @NotBlank
    @Size(max = 50)
    private String bin;
}
