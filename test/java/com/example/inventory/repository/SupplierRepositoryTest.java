package com.example.inventory.repository;

import com.example.inventory.entity.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SupplierRepositoryTest {
    @Autowired
    private SupplierRepository repo;

    @Test
    void saveAndFindById() {
        Supplier s = Supplier.builder().name("Supplier1").build();
        Supplier saved = repo.save(s);
        assertThat(saved.getId()).isNotNull();
        Supplier found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Supplier1");
    }

    @Test
    void deleteById() {
        Supplier s = Supplier.builder().name("Supplier2").build();
        Supplier saved = repo.save(s);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
