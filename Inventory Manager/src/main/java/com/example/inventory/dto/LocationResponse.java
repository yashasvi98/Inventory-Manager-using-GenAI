package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for location response data.
 */
@Data
@Builder
public class LocationResponse {
    /** Unique identifier for the location. */
    private Long id;
    /** Item ID assigned to the location. */
    private Long itemId;
    /** Warehouse ID where the item is stored. */
    private Long warehouseId;
    /** Warehouse zone. */
    private String zone;
    /** Bin within the warehouse zone. */
    private String bin;
}
