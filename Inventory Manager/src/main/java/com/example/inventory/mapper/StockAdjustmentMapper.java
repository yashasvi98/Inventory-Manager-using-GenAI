package com.example.inventory.mapper;

import com.example.inventory.dto.StockAdjustmentRequest;
import com.example.inventory.dto.StockAdjustmentResponse;
import com.example.inventory.entity.StockAdjustment;

public final class StockAdjustmentMapper {
    private StockAdjustmentMapper() {}

    /**
     * Converts a StockAdjustmentRequest DTO to a StockAdjustment entity.
     */
    public static StockAdjustment toEntity(StockAdjustmentRequest req) {
        StockAdjustment sa = new StockAdjustment();
        sa.setItemId(req.getItemId());
        sa.setQuantity(req.getQuantity());
        sa.setReason(req.getReason());
        sa.setAdjustedBy(req.getAdjustedBy());
        return sa;
    }

    /**
     * Converts a StockAdjustment entity to a StockAdjustmentResponse DTO.
     */
    public static StockAdjustmentResponse toResponse(StockAdjustment sa) {
        return StockAdjustmentResponse.builder()
            .id(sa.getId())
            .itemId(sa.getItemId())
            .quantity(sa.getQuantity())
            .reason(sa.getReason())
            .adjustedAt(sa.getAdjustedAt())
            .adjustedBy(sa.getAdjustedBy())
            .build();
    }
}
