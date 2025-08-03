package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ReservationResponseTest {
    @Test
    void builder_and_getters_work() {
        ReservationResponse resp = ReservationResponse.builder()
                .id(1L)
                .itemId(2L)
                .quantity(3)
                .reservedFor("User")
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getItemId()).isEqualTo(2L);
        assertThat(resp.getQuantity()).isEqualTo(3);
        assertThat(resp.getReservedFor()).isEqualTo("User");
    }
}
