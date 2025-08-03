package com.example.inventory.repository;

import com.example.inventory.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repo;

    @Test
    void saveAndFindById() {
        Category c = Category.builder().name("Electronics").build();
        Category saved = repo.save(c);
        assertThat(saved.getId()).isNotNull();
        Category found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Electronics");
    }

    @Test
    void existsByName() {
        Category c = Category.builder().name("Furniture").build();
        repo.save(c);
        assertThat(repo.existsByName("Furniture")).isTrue();
        assertThat(repo.existsByName("Nonexistent")).isFalse();
    }

    @Test
    void deleteById() {
        Category c = Category.builder().name("Toys").build();
        Category saved = repo.save(c);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
