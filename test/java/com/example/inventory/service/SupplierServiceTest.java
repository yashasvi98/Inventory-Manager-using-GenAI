package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SupplierServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.SupplierService supplierService;
    @org.mockito.Mock
    private com.example.inventory.repository.SupplierRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withValidRequest_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.SupplierRequest.builder().name("Supplier1").build();
        var entity = com.example.inventory.entity.Supplier.builder().name("Supplier1").build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = supplierService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withNullRequest_throwsException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> supplierService.create(null))
                .isInstanceOf(NullPointerException.class);
    }

}
