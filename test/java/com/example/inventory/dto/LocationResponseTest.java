package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LocationResponseTest {
    @Test
    void builder_and_getters_work() {
        LocationResponse resp = LocationResponse.builder()
                .id(1L)
                .name("Loc")
                .type("SHELF")
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getName()).isEqualTo("Loc");
        assertThat(resp.getType()).isEqualTo("SHELF");
    }
}
