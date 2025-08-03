package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {
    @Test
    void builderAndGettersSetters() {
        Reservation r = Reservation.builder().id(1L).itemId(2L).quantity(3).reservedFor("User").build();
        assertThat(r.getId()).isEqualTo(1L);
        assertThat(r.getItemId()).isEqualTo(2L);
        assertThat(r.getQuantity()).isEqualTo(3);
        assertThat(r.getReservedFor()).isEqualTo("User");
    }

    @Test
    void equalsAndHashCode() {
        Reservation r1 = Reservation.builder().id(1L).reservedFor("A").build();
        Reservation r2 = Reservation.builder().id(1L).reservedFor("A").build();
        assertThat(r1).isEqualTo(r2);
        assertThat(r1.hashCode()).isEqualTo(r2.hashCode());
    }

    @Test
    void toStringWorks() {
        Reservation r = Reservation.builder().id(1L).reservedFor("A").build();
        assertThat(r.toString()).contains("A");
    }
}
