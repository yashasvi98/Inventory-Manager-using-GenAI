package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LowStockAlertServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.LowStockAlertService lowStockAlertService;
    @org.mockito.Mock
    private com.example.inventory.repository.ItemRepository itemRepository;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void getLowStockItems_withNoItems_returnsEmptyList() {
        org.mockito.Mockito.when(itemRepository.findAll()).thenReturn(java.util.Collections.emptyList());
        var resp = lowStockAlertService.getLowStockItems();
        org.assertj.core.api.Assertions.assertThat(resp).isEmpty();
    }

    @org.junit.jupiter.api.Test
    void getLowStockItems_withLowStockItems_returnsAlerts() {
        var item = com.example.inventory.entity.Item.builder().id(1L).name("Item1").currentStock(2).lowStockThreshold(5).build();
        org.mockito.Mockito.when(itemRepository.findAll()).thenReturn(java.util.List.of(item));
        var resp = lowStockAlertService.getLowStockItems();
        org.assertj.core.api.Assertions.assertThat(resp).hasSize(1);
        org.assertj.core.api.Assertions.assertThat(resp.get(0).getItemId()).isEqualTo(1L);
    }

}
