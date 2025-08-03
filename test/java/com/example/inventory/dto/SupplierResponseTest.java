package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SupplierResponseTest {
    @Test
    void builder_and_getters_work() {
        SupplierResponse resp = SupplierResponse.builder()
                .id(1L)
                .name("Supplier")
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getName()).isEqualTo("Supplier");
    }
}
