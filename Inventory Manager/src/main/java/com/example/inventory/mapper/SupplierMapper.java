package com.example.inventory.mapper;

import com.example.inventory.dto.SupplierRequest;
import com.example.inventory.dto.SupplierResponse;
import com.example.inventory.entity.Supplier;

public class SupplierMapper {
    public static Supplier toEntity(SupplierRequest req) {
        Supplier s = new Supplier();
        s.setName(req.getName());
        s.setContact(req.getContact());
        return s;
    }

    public static SupplierResponse toResponse(Supplier s) {
        return SupplierResponse.builder()
            .id(s.getId())
            .name(s.getName())
            .contact(s.getContact())
            .build();
    }
}
