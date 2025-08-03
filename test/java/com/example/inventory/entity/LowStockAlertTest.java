package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LowStockAlertTest {
    @Test
    void builderAndGettersSetters() {
        LowStockAlert a = LowStockAlert.builder().id(1L).itemId(2L).alertMessage("Low").build();
        assertThat(a.getId()).isEqualTo(1L);
        assertThat(a.getItemId()).isEqualTo(2L);
        assertThat(a.getAlertMessage()).isEqualTo("Low");
    }

    @Test
    void equalsAndHashCode() {
        LowStockAlert a1 = LowStockAlert.builder().id(1L).alertMessage("A").build();
        LowStockAlert a2 = LowStockAlert.builder().id(1L).alertMessage("A").build();
        assertThat(a1).isEqualTo(a2);
        assertThat(a1.hashCode()).isEqualTo(a2.hashCode());
    }

    @Test
    void toStringWorks() {
        LowStockAlert a = LowStockAlert.builder().id(1L).alertMessage("A").build();
        assertThat(a.toString()).contains("A");
    }
}
