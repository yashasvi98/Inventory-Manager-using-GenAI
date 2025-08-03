package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.ItemService itemService;
    @org.mockito.Mock
    private com.example.inventory.repository.ItemRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withUniqueSku_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.ItemRequest.builder().name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.existsBySku("SKU1")).thenReturn(false);
        var entity = com.example.inventory.entity.Item.builder().name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = itemService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withDuplicateSku_throwsConflict() {
        var req = com.example.inventory.dto.ItemRequest.builder().name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.existsBySku("SKU1")).thenReturn(true);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> itemService.create(req))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("409");
    }

    @org.junit.jupiter.api.Test
    void listAll_whenEmpty_returnsEmptyList() {
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.Collections.emptyList());
        var resp = itemService.listAll();
        org.assertj.core.api.Assertions.assertThat(resp).isEmpty();
    }

    @org.junit.jupiter.api.Test
    void listAll_withMultiple_returnsAllMapped() {
        var item = com.example.inventory.entity.Item.builder().id(1L).name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.List.of(item));
        var resp = itemService.listAll();
        org.assertj.core.api.Assertions.assertThat(resp).hasSize(1);
    }

    @org.junit.jupiter.api.Test
    void getById_withValidId_returnsItem() {
        var item = com.example.inventory.entity.Item.builder().id(1L).name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(item));
        var resp = itemService.getById(1L);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
    }

    @org.junit.jupiter.api.Test
    void getById_withInvalidId_throwsNotFound() {
        org.mockito.Mockito.when(repo.findById(99L)).thenReturn(java.util.Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> itemService.getById(99L))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("404");
    }

    @org.junit.jupiter.api.Test
    void update_withValidIdAndUniqueSku_updatesAndReturnsResponse() {
        var req = com.example.inventory.dto.ItemRequest.builder().name("Item2").sku("SKU2").categoryId(2L).build();
        var existing = com.example.inventory.entity.Item.builder().id(1L).name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(existing));
        org.mockito.Mockito.when(repo.existsBySku("SKU2")).thenReturn(false);
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(existing);
        var resp = itemService.update(1L, req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
    }

    @org.junit.jupiter.api.Test
    void update_withInvalidId_throwsNotFound() {
        var req = com.example.inventory.dto.ItemRequest.builder().name("Item2").sku("SKU2").categoryId(2L).build();
        org.mockito.Mockito.when(repo.findById(99L)).thenReturn(java.util.Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> itemService.update(99L, req))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("404");
    }

    @org.junit.jupiter.api.Test
    void update_withDuplicateSku_throwsConflict() {
        var req = com.example.inventory.dto.ItemRequest.builder().name("Item2").sku("SKU2").categoryId(2L).build();
        var existing = com.example.inventory.entity.Item.builder().id(1L).name("Item1").sku("SKU1").categoryId(1L).build();
        org.mockito.Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(existing));
        org.mockito.Mockito.when(repo.existsBySku("SKU2")).thenReturn(true);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> itemService.update(1L, req))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("409");
    }

    @org.junit.jupiter.api.Test
    void delete_withValidId_deletesItem() {
        org.mockito.Mockito.when(repo.existsById(1L)).thenReturn(true);
        itemService.delete(1L);
        org.mockito.Mockito.verify(repo).deleteById(1L);
    }

    @org.junit.jupiter.api.Test
    void delete_withInvalidId_throwsNotFound() {
        org.mockito.Mockito.when(repo.existsById(99L)).thenReturn(false);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> itemService.delete(99L))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("404");
    }
}
