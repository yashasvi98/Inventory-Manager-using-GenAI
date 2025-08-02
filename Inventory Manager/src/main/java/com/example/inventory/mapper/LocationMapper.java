package com.example.inventory.mapper;

import com.example.inventory.dto.LocationRequest;
import com.example.inventory.dto.LocationResponse;
import com.example.inventory.entity.Location;

public final class LocationMapper {
    private LocationMapper() {}

    /**
     * Converts a LocationRequest DTO to a Location entity.
     */
    public static Location toEntity(LocationRequest req) {
        Location l = new Location();
        l.setItemId(req.getItemId());
        l.setWarehouseId(req.getWarehouseId());
        l.setZone(req.getZone());
        l.setBin(req.getBin());
        return l;
    }

    /**
     * Converts a Location entity to a LocationResponse DTO.
     */
    public static LocationResponse toResponse(Location l) {
        return LocationResponse.builder()
            .id(l.getId())
            .itemId(l.getItemId())
            .warehouseId(l.getWarehouseId())
            .zone(l.getZone())
            .bin(l.getBin())
            .build();
    }
}
