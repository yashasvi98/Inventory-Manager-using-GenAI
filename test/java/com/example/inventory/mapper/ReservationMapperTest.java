package com.example.inventory.mapper;

import com.example.inventory.dto.ReservationRequest;
import com.example.inventory.dto.ReservationResponse;
import com.example.inventory.entity.Reservation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ReservationMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        ReservationRequest req = ReservationRequest.builder().itemId(1L).quantity(2).reservedFor("User").build();
        Reservation r = ReservationMapper.toEntity(req);
        assertThat(r.getItemId()).isEqualTo(1L);
        assertThat(r.getQuantity()).isEqualTo(2);
        assertThat(r.getReservedFor()).isEqualTo("User");
    }

    @Test
    void toResponse_mapsAllFields() {
        Reservation entity = Reservation.builder().id(2L).itemId(1L).quantity(2).reservedFor("User").build();
        ReservationResponse resp = ReservationMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getItemId()).isEqualTo(1L);
        assertThat(resp.getQuantity()).isEqualTo(2);
        assertThat(resp.getReservedFor()).isEqualTo("User");
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> ReservationMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> ReservationMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}
