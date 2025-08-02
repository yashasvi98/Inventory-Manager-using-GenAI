package com.example.inventory.mapper;

import com.example.inventory.dto.ReservationRequest;
import com.example.inventory.dto.ReservationResponse;
import com.example.inventory.entity.Reservation;

public final class ReservationMapper {
    private ReservationMapper() {}

    /**
     * Converts a ReservationRequest DTO to a Reservation entity.
     */
    public static Reservation toEntity(ReservationRequest req) {
        Reservation r = new Reservation();
        r.setOrderId(req.getOrderId());
        r.setItemId(req.getItemId());
        r.setQuantity(req.getQuantity());
        r.setStatus("PENDING");
        return r;
    }

    /**
     * Converts a Reservation entity to a ReservationResponse DTO.
     */
    public static ReservationResponse toResponse(Reservation r) {
        return ReservationResponse.builder()
            .id(r.getId())
            .orderId(r.getOrderId())
            .itemId(r.getItemId())
            .quantity(r.getQuantity())
            .status(r.getStatus())
            .reservedAt(r.getReservedAt())
            .expiresAt(r.getExpiresAt())
            .build();
    }
}
