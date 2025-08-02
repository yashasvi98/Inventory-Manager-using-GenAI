package com.example.inventory.mapper;

import com.example.inventory.dto.TransferRequest;
import com.example.inventory.dto.TransferResponse;
import com.example.inventory.entity.Transfer;

public class TransferMapper {
    public static Transfer toEntity(TransferRequest req) {
        Transfer t = new Transfer();
        t.setItemId(req.getItemId());
        t.setFromWarehouseId(req.getFromWarehouseId());
        t.setToWarehouseId(req.getToWarehouseId());
        t.setQuantity(req.getQuantity());
        return t;
    }

    public static TransferResponse toResponse(Transfer t) {
        return TransferResponse.builder()
            .id(t.getId())
            .itemId(t.getItemId())
            .fromWarehouseId(t.getFromWarehouseId())
            .toWarehouseId(t.getToWarehouseId())
            .quantity(t.getQuantity())
            .transferDate(t.getTransferDate())
            .build();
    }
}
