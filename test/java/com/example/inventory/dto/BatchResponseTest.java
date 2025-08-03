package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BatchResponseTest {
    @Test
    void builder_and_getters_work() {
        BatchResponse resp = BatchResponse.builder()
                .id(1L)
                .batchNumber("B123")
                .itemId(2L)
                .quantity(10)
                .expiryDate(null)
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getBatchNumber()).isEqualTo("B123");
        assertThat(resp.getItemId()).isEqualTo(2L);
        assertThat(resp.getQuantity()).isEqualTo(10);
        assertThat(resp.getExpiryDate()).isNull();
    }
}
