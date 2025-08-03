package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ItemResponseTest {
    @Test
    void builder_and_getters_work() {
        ItemResponse resp = ItemResponse.builder()
                .id(1L)
                .name("TestItem")
                .sku("SKU123")
                .categoryId(2L)
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getName()).isEqualTo("TestItem");
        assertThat(resp.getSku()).isEqualTo("SKU123");
        assertThat(resp.getCategoryId()).isEqualTo(2L);
    }
}
