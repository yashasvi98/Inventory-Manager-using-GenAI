package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TransferTest {
    @Test
    void builderAndGettersSetters() {
        Transfer t = Transfer.builder().id(1L).itemId(2L).quantity(3).sourceLocationId(4L).destinationLocationId(5L).build();
        assertThat(t.getId()).isEqualTo(1L);
        assertThat(t.getItemId()).isEqualTo(2L);
        assertThat(t.getQuantity()).isEqualTo(3);
        assertThat(t.getSourceLocationId()).isEqualTo(4L);
        assertThat(t.getDestinationLocationId()).isEqualTo(5L);
    }

    @Test
    void equalsAndHashCode() {
        Transfer t1 = Transfer.builder().id(1L).itemId(2L).build();
        Transfer t2 = Transfer.builder().id(1L).itemId(2L).build();
        assertThat(t1).isEqualTo(t2);
        assertThat(t1.hashCode()).isEqualTo(t2.hashCode());
    }

    @Test
    void toStringWorks() {
        Transfer t = Transfer.builder().id(1L).itemId(2L).build();
        assertThat(t.toString()).contains("2");
    }
}
