package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatchServiceTest {
    @org.mockito.InjectMocks
    private BatchService batchService;
    @org.mockito.Mock
    private com.example.inventory.repository.BatchRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withValidRequest_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.BatchRequest.builder()
                .batchNumber("B1").itemId(1L).quantity(10).expiryDate(java.time.LocalDate.now().plusDays(1)).build();
        var entity = com.example.inventory.entity.Batch.builder().batchNumber("B1").itemId(1L).quantity(10).expiryDate(java.time.LocalDate.now().plusDays(1)).build();
        var saved = entity;
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(saved);
        var resp = batchService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withPastExpiry_throwsException() {
        var req = com.example.inventory.dto.BatchRequest.builder()
                .batchNumber("B1").itemId(1L).quantity(10).expiryDate(java.time.LocalDate.now().minusDays(1)).build();
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> batchService.create(req))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @org.junit.jupiter.api.Test
    void create_withNullRequest_throwsException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> batchService.create(null))
                .isInstanceOf(NullPointerException.class);
    }
}
