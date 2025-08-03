package com.example.inventory.repository;

import com.example.inventory.entity.LowStockAlert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LowStockAlertRepositoryTest {
    @Autowired
    private LowStockAlertRepository repo;

    @Test
    void saveAndFindById() {
        LowStockAlert a = LowStockAlert.builder().itemId(1L).alertMessage("Low stock").build();
        LowStockAlert saved = repo.save(a);
        assertThat(saved.getId()).isNotNull();
        LowStockAlert found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getAlertMessage()).isEqualTo("Low stock");
    }

    @Test
    void deleteById() {
        LowStockAlert a = LowStockAlert.builder().itemId(2L).alertMessage("Critical").build();
        LowStockAlert saved = repo.save(a);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
