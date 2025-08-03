package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryResponseTest {
    @Test
    void builder_and_getters_work() {
        CategoryResponse resp = CategoryResponse.builder()
                .id(1L)
                .name("TestCat")
                .build();
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getName()).isEqualTo("TestCat");
    }
}
