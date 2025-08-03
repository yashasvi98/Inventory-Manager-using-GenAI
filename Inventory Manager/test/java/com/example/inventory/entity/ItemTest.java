package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void builderAndGettersSetters() {
        Item i = Item.builder().id(1L).name("Item1").sku("SKU1").categoryId(2L).build();
        assertThat(i.getId()).isEqualTo(1L);
        assertThat(i.getName()).isEqualTo("Item1");
        assertThat(i.getSku()).isEqualTo("SKU1");
        assertThat(i.getCategoryId()).isEqualTo(2L);
    }

    @Test
    void equalsAndHashCode() {
        Item i1 = Item.builder().id(1L).sku("SKU1").build();
        Item i2 = Item.builder().id(1L).sku("SKU1").build();
        assertThat(i1).isEqualTo(i2);
        assertThat(i1.hashCode()).isEqualTo(i2.hashCode());
    }

    @Test
    void toStringWorks() {
        Item i = Item.builder().id(1L).sku("SKU1").build();
        assertThat(i.toString()).contains("SKU1");
    }
}
