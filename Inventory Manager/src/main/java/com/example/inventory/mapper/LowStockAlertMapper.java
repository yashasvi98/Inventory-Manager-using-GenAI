package com.example.inventory.mapper;

import com.example.inventory.dto.LowStockAlertResponse;
import com.example.inventory.entity.LowStockAlert;

public final class LowStockAlertMapper {
    private LowStockAlertMapper() {}

    /**
     * Converts a LowStockAlert entity to a LowStockAlertResponse DTO.
     */
    public static LowStockAlertResponse toResponse(LowStockAlert a) {
        return LowStockAlertResponse.builder()
            .id(a.getId())
            .itemId(a.getItemId())
            .threshold(a.getThreshold())
            .triggeredAt(a.getTriggeredAt())
            .notified(a.getNotified())
            .build();
    }
}
