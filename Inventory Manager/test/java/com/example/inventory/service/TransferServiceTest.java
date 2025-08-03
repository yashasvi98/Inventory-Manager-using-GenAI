package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransferServiceTest {
    @org.mockito.InjectMocks
    private TransferService transferService;
    @org.mockito.Mock
    private TransferRepository repo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        org.mockito.MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    void transfer_withValidInput_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.TransferRequest.builder()
                .itemId(1L).quantity(5).sourceLocationId(2L).destinationLocationId(3L).build();
        var entity = com.example.inventory.entity.Transfer.builder().itemId(1L).quantity(5).build();
        var saved = com.example.inventory.entity.Transfer.builder().itemId(1L).quantity(5).build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(saved);
        var resp = transferService.transfer(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void transfer_withNullRequest_throwsException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> transferService.transfer(null))
                .isInstanceOf(NullPointerException.class);
    }


}
