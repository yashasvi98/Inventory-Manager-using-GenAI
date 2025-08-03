package com.example.inventory.repository;

import com.example.inventory.entity.Transfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TransferRepositoryTest {
    @Autowired
    private TransferRepository repo;

    @Test
    void saveAndFindById() {
        Transfer t = Transfer.builder().itemId(1L).quantity(5).sourceLocationId(2L).destinationLocationId(3L).build();
        Transfer saved = repo.save(t);
        assertThat(saved.getId()).isNotNull();
        Transfer found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getItemId()).isEqualTo(1L);
    }

    @Test
    void deleteById() {
        Transfer t = Transfer.builder().itemId(2L).quantity(3).sourceLocationId(4L).destinationLocationId(5L).build();
        Transfer saved = repo.save(t);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
