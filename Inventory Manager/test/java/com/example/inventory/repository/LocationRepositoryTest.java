package com.example.inventory.repository;

import com.example.inventory.entity.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LocationRepositoryTest {
    @Autowired
    private LocationRepository repo;

    @Test
    void saveAndFindById() {
        Location l = Location.builder().name("Loc1").type("SHELF").build();
        Location saved = repo.save(l);
        assertThat(saved.getId()).isNotNull();
        Location found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Loc1");
    }

    @Test
    void existsByName() {
        Location l = Location.builder().name("Loc2").type("BIN").build();
        repo.save(l);
        assertThat(repo.existsByName("Loc2")).isTrue();
        assertThat(repo.existsByName("Nonexistent")).isFalse();
    }

    @Test
    void deleteById() {
        Location l = Location.builder().name("Loc3").type("BIN").build();
        Location saved = repo.save(l);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
