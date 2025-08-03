package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockAdjustmentServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.StockAdjustmentService stockAdjustmentService;
    @org.mockito.Mock
    private com.example.inventory.repository.StockAdjustmentRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void adjust_withValidRequest_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.StockAdjustmentRequest.builder().itemId(1L).quantityChange(5).reason("Restock").build();
        var entity = com.example.inventory.entity.StockAdjustment.builder().itemId(1L).quantityChange(5).reason("Restock").build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = stockAdjustmentService.adjust(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void adjust_withNullRequest_throwsException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> stockAdjustmentService.adjust(null))
                .isInstanceOf(NullPointerException.class);
    }

}
