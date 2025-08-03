package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StockAdjustmentTest {
    @Test
    void builderAndGettersSetters() {
        StockAdjustment s = StockAdjustment.builder().id(1L).itemId(2L).quantityChange(5).reason("Restock").build();
        assertThat(s.getId()).isEqualTo(1L);
        assertThat(s.getItemId()).isEqualTo(2L);
        assertThat(s.getQuantityChange()).isEqualTo(5);
        assertThat(s.getReason()).isEqualTo("Restock");
    }

    @Test
    void equalsAndHashCode() {
        StockAdjustment s1 = StockAdjustment.builder().id(1L).reason("A").build();
        StockAdjustment s2 = StockAdjustment.builder().id(1L).reason("A").build();
        assertThat(s1).isEqualTo(s2);
        assertThat(s1.hashCode()).isEqualTo(s2.hashCode());
    }

    @Test
    void toStringWorks() {
        StockAdjustment s = StockAdjustment.builder().id(1L).reason("A").build();
        assertThat(s.toString()).contains("A");
    }
}
