package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {
    @Test
    void builderAndGettersSetters() {
        Category c = Category.builder().id(1L).name("Electronics").build();
        assertThat(c.getId()).isEqualTo(1L);
        assertThat(c.getName()).isEqualTo("Electronics");
    }

    @Test
    void equalsAndHashCode() {
        Category c1 = Category.builder().id(1L).name("A").build();
        Category c2 = Category.builder().id(1L).name("A").build();
        assertThat(c1).isEqualTo(c2);
        assertThat(c1.hashCode()).isEqualTo(c2.hashCode());
    }

    @Test
    void toStringWorks() {
        Category c = Category.builder().id(1L).name("A").build();
        assertThat(c.toString()).contains("A");
    }
}
