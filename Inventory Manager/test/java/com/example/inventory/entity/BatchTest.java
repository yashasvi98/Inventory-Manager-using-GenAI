package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

class BatchTest {
    @Test
    void builderAndGettersSetters() {
        Batch b = Batch.builder()
                .id(1L)
                .itemId(2L)
                .batchNumber("B1")
                .expiryDate(LocalDate.now().plusDays(10))
                .quantity(5)
                .build();
        assertThat(b.getId()).isEqualTo(1L);
        assertThat(b.getItemId()).isEqualTo(2L);
        assertThat(b.getBatchNumber()).isEqualTo("B1");
        assertThat(b.getQuantity()).isEqualTo(5);
    }

    @Test
    void equalsAndHashCode() {
        Batch b1 = Batch.builder().id(1L).batchNumber("B1").build();
        Batch b2 = Batch.builder().id(1L).batchNumber("B1").build();
        assertThat(b1).isEqualTo(b2);
        assertThat(b1.hashCode()).isEqualTo(b2.hashCode());
    }

    @Test
    void toStringWorks() {
        Batch b = Batch.builder().id(1L).batchNumber("B1").build();
        assertThat(b.toString()).contains("B1");
    }
}
