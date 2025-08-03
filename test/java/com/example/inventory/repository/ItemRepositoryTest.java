package com.example.inventory.repository;

import com.example.inventory.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository repo;

    @Test
    void saveAndFindById() {
        Item i = Item.builder().name("Item1").sku("SKU1").categoryId(1L).build();
        Item saved = repo.save(i);
        assertThat(saved.getId()).isNotNull();
        Item found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getSku()).isEqualTo("SKU1");
    }

    @Test
    void existsBySku() {
        Item i = Item.builder().name("Item2").sku("SKU2").categoryId(2L).build();
        repo.save(i);
        assertThat(repo.existsBySku("SKU2")).isTrue();
        assertThat(repo.existsBySku("NOSKU")).isFalse();
    }

    @Test
    void deleteById() {
        Item i = Item.builder().name("Item3").sku("SKU3").categoryId(3L).build();
        Item saved = repo.save(i);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
