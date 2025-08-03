package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StockAdjustmentResponseTest {
    @Test
    void builder_and_getters_work() {
        StockAdjustmentResponse resp = StockAdjustmentResponse.builder()
                .id(1L)
                .itemId(2L)
                .quantityChange(5)
                .reason("Restock")
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getItemId()).isEqualTo(2L);
        assertThat(resp.getQuantityChange()).isEqualTo(5);
        assertThat(resp.getReason()).isEqualTo("Restock");
    }
}
