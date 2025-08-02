package com.example.inventory.mapper;

import com.example.inventory.dto.BatchRequest;
import com.example.inventory.dto.BatchResponse;
import com.example.inventory.entity.Batch;

public final class BatchMapper {
    private BatchMapper() {}

    /**
     * Converts a BatchRequest DTO to a Batch entity.
     */
    public static Batch toEntity(BatchRequest req) {
        Batch b = new Batch();
        b.setItemId(req.getItemId());
        b.setBatchNumber(req.getBatchNumber());
        b.setExpiryDate(req.getExpiryDate());
        b.setQuantity(req.getQuantity());
        return b;
    }

    /**
     * Converts a Batch entity to a BatchResponse DTO.
     */
    public static BatchResponse toResponse(Batch b) {
        return BatchResponse.builder()
            .id(b.getId())
            .itemId(b.getItemId())
            .batchNumber(b.getBatchNumber())
            .expiryDate(b.getExpiryDate())
            .quantity(b.getQuantity())
            .build();
    }
}
