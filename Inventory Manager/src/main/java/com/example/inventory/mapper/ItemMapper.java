package com.example.inventory.mapper;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.dto.ItemResponse;
import com.example.inventory.entity.Item;

public class ItemMapper {
    public static Item toEntity(ItemRequest req) {
        Item i = new Item();
        i.setName(req.getName());
        i.setDescription(req.getDescription());
        i.setSku(req.getSku());
        i.setCategoryId(req.getCategoryId());
        i.setSupplierId(req.getSupplierId());
        return i;
    }

    public static ItemResponse toResponse(Item i) {
        return ItemResponse.builder()
            .id(i.getId())
            .name(i.getName())
            .description(i.getDescription())
            .sku(i.getSku())
            .categoryId(i.getCategoryId())
            .supplierId(i.getSupplierId())
            .createdAt(i.getCreatedAt())
            .updatedAt(i.getUpdatedAt())
            .build();
    }
}
