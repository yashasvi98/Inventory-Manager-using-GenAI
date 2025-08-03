package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.LocationService locationService;
    @org.mockito.Mock
    private com.example.inventory.repository.LocationRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withUniqueName_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.LocationRequest.builder().name("Loc1").type("SHELF").build();
        org.mockito.Mockito.when(repo.existsByName("Loc1")).thenReturn(false);
        var entity = com.example.inventory.entity.Location.builder().name("Loc1").type("SHELF").build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = locationService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withDuplicateName_throwsConflict() {
        var req = com.example.inventory.dto.LocationRequest.builder().name("Loc1").type("SHELF").build();
        org.mockito.Mockito.when(repo.existsByName("Loc1")).thenReturn(true);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> locationService.create(req))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("409");
    }

    @org.junit.jupiter.api.Test
    void list_whenEmpty_returnsEmptyList() {
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.Collections.emptyList());
        var resp = locationService.list();
        org.assertj.core.api.Assertions.assertThat(resp).isEmpty();
    }

    @org.junit.jupiter.api.Test
    void list_withMultiple_returnsAllMapped() {
        var loc = com.example.inventory.entity.Location.builder().id(1L).name("Loc1").type("SHELF").build();
        org.mockito.Mockito.when(repo.findAll()).thenReturn(java.util.List.of(loc));
        var resp = locationService.list();
        org.assertj.core.api.Assertions.assertThat(resp).hasSize(1);
    }

    @org.junit.jupiter.api.Test
    void get_withValidId_returnsLocation() {
        var loc = com.example.inventory.entity.Location.builder().id(1L).name("Loc1").type("SHELF").build();
        org.mockito.Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(loc));
        var resp = locationService.get(1L);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
    }

    @org.junit.jupiter.api.Test
    void get_withInvalidId_throwsNotFound() {
        org.mockito.Mockito.when(repo.findById(99L)).thenReturn(java.util.Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> locationService.get(99L))
                .isInstanceOf(org.springframework.web.server.ResponseStatusException.class)
                .hasMessageContaining("404");
    }

}
