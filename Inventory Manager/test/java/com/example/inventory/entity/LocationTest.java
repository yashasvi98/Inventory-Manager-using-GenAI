package com.example.inventory.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {
    @Test
    void builderAndGettersSetters() {
        Location l = Location.builder().id(1L).name("Loc1").type("SHELF").build();
        assertThat(l.getId()).isEqualTo(1L);
        assertThat(l.getName()).isEqualTo("Loc1");
        assertThat(l.getType()).isEqualTo("SHELF");
    }

    @Test
    void equalsAndHashCode() {
        Location l1 = Location.builder().id(1L).name("L").build();
        Location l2 = Location.builder().id(1L).name("L").build();
        assertThat(l1).isEqualTo(l2);
        assertThat(l1.hashCode()).isEqualTo(l2.hashCode());
    }

    @Test
    void toStringWorks() {
        Location l = Location.builder().id(1L).name("L").build();
        assertThat(l.toString()).contains("L");
    }
}
