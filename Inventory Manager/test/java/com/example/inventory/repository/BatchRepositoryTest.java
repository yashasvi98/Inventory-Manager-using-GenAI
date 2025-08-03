package com.example.inventory.repository;

import com.example.inventory.entity.Batch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BatchRepositoryTest {
    @Autowired
    private BatchRepository repo;

    @Test
    void saveAndFindById() {
        Batch b = Batch.builder().itemId(1L).batchNumber("B1").expiryDate(LocalDate.now().plusDays(10)).quantity(5).build();
        Batch saved = repo.save(b);
        assertThat(saved.getId()).isNotNull();
        Batch found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getBatchNumber()).isEqualTo("B1");
    }

    @Test
    void findByBatchNumber() {
        Batch b = Batch.builder().itemId(2L).batchNumber("B2").expiryDate(LocalDate.now().plusDays(5)).quantity(3).build();
        repo.save(b);
        Batch found = repo.findByBatchNumber("B2");
        assertThat(found).isNotNull();
        assertThat(found.getBatchNumber()).isEqualTo("B2");
    }

    @Test
    void deleteById() {
        Batch b = Batch.builder().itemId(3L).batchNumber("B3").expiryDate(LocalDate.now().plusDays(7)).quantity(8).build();
        Batch saved = repo.save(b);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
