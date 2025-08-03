package com.example.inventory.repository;

import com.example.inventory.entity.StockAdjustment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StockAdjustmentRepositoryTest {
    @Autowired
    private StockAdjustmentRepository repo;

    @Test
    void saveAndFindById() {
        StockAdjustment s = StockAdjustment.builder().itemId(1L).quantityChange(5).reason("Restock").build();
        StockAdjustment saved = repo.save(s);
        assertThat(saved.getId()).isNotNull();
        StockAdjustment found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getReason()).isEqualTo("Restock");
    }

    @Test
    void deleteById() {
        StockAdjustment s = StockAdjustment.builder().itemId(2L).quantityChange(-2).reason("Correction").build();
        StockAdjustment saved = repo.save(s);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
