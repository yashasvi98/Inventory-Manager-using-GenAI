package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {
    @org.mockito.InjectMocks
    private CategoryService categoryService;
    @org.mockito.Mock
    private com.example.inventory.repository.CategoryRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withUniqueName_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.CategoryRequest.builder().name("Cat1").build();
        org.mockito.Mockito.when(repo.existsByName("Cat1")).thenReturn(false);
        var entity = com.example.inventory.entity.Category.builder().name("Cat1").build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = categoryService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withDuplicateName_throwsConflict() {
        var req = com.example.inventory.dto.CategoryRequest.builder().name("Cat1").build();
        org.mockito.Mockito.when(repo.existsByName("Cat1")).thenReturn(true);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> categoryService.create(req))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("409");
    }

    @org.junit.jupiter.api.Test
    void list_whenEmpty_returnsEmptyList() {
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.Collections.emptyList());
        var resp = categoryService.list();
        org.assertj.core.api.Assertions.assertThat(resp).isEmpty();
    }

    @org.junit.jupiter.api.Test
    void list_withMultiple_returnsAllMapped() {
        var cat = com.example.inventory.entity.Category.builder().id(1L).name("Cat1").build();
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.List.of(cat));
        var resp = categoryService.list();
        org.assertj.core.api.Assertions.assertThat(resp).hasSize(1);
    }

    @org.junit.jupiter.api.Test
    void get_withValidId_returnsCategory() {
        var cat = com.example.inventory.entity.Category.builder().id(1L).name("Cat1").build();
        org.mockito.Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(cat));
        var resp = categoryService.get(1L);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
    }

    @org.junit.jupiter.api.Test
    void get_withInvalidId_throwsNotFound() {
        org.mockito.Mockito.when(repo.findById(99L)).thenReturn(java.util.Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> categoryService.get(99L))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("404");
    }

}
