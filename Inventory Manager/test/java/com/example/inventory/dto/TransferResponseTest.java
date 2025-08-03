package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TransferResponseTest {
    @Test
    void builder_and_getters_work() {
        TransferResponse resp = TransferResponse.builder()
                .id(1L)
                .itemId(2L)
                .quantity(5)
                .sourceLocationId(3L)
                .destinationLocationId(4L)
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getItemId()).isEqualTo(2L);
        assertThat(resp.getQuantity()).isEqualTo(5);
        assertThat(resp.getSourceLocationId()).isEqualTo(3L);
        assertThat(resp.getDestinationLocationId()).isEqualTo(4L);
    }
}
