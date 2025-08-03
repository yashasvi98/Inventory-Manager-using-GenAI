package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LowStockAlertResponseTest {
    @Test
    void builder_and_getters_work() {
        LowStockAlertResponse resp = LowStockAlertResponse.builder()
                .itemId(1L)
                .itemName("Item")
                .currentStock(5)
                .threshold(10)
                .build();
        assertThat(resp.getItemId()).isEqualTo(1L);
        assertThat(resp.getItemName()).isEqualTo("Item");
        assertThat(resp.getCurrentStock()).isEqualTo(5);
        assertThat(resp.getThreshold()).isEqualTo(10);
    }
}
