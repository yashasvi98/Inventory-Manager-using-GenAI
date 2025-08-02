package com.example.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * DTO for low stock alert response data.
 */
@Data
@Builder
public class LowStockAlertResponse {
    /** Unique identifier for the alert. */
    private Long id;
    /** Item ID associated with the alert. */
    private Long itemId;
    /** Stock threshold that triggered the alert. */
    private Integer threshold;
    /** Timestamp when the alert was triggered. */
    private Instant triggeredAt;
    /** Whether the alert has been notified. */
    private Boolean notified;
}
