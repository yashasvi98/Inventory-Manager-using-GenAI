package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SupplierTest {
    @Test
    void builderAndGettersSetters() {
        Supplier s = Supplier.builder().id(1L).name("Supplier1").build();
        assertThat(s.getId()).isEqualTo(1L);
        assertThat(s.getName()).isEqualTo("Supplier1");
    }

    @Test
    void equalsAndHashCode() {
        Supplier s1 = Supplier.builder().id(1L).name("A").build();
        Supplier s2 = Supplier.builder().id(1L).name("A").build();
        assertThat(s1).isEqualTo(s2);
        assertThat(s1.hashCode()).isEqualTo(s2.hashCode());
    }

    @Test
    void toStringWorks() {
        Supplier s = Supplier.builder().id(1L).name("A").build();
        assertThat(s.toString()).contains("A");
    }
}
