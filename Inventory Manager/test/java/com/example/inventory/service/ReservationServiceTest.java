package com.example.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServiceTest {
    @org.mockito.InjectMocks
    private com.example.inventory.service.ReservationService reservationService;
    @org.mockito.Mock
    private com.example.inventory.repository.ReservationRepository repo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() { org.mockito.MockitoAnnotations.openMocks(this); }

    @org.junit.jupiter.api.Test
    void create_withValidRequest_savesAndReturnsResponse() {
        var req = com.example.inventory.dto.ReservationRequest.builder().itemId(1L).quantity(2).reservedFor("User").build();
        var entity = com.example.inventory.entity.Reservation.builder().itemId(1L).quantity(2).reservedFor("User").build();
        org.mockito.Mockito.when(repo.save(org.mockito.Mockito.any())).thenReturn(entity);
        var resp = reservationService.create(req);
        org.assertj.core.api.Assertions.assertThat(resp).isNotNull();
        org.mockito.Mockito.verify(repo).save(org.mockito.Mockito.any());
    }

    @org.junit.jupiter.api.Test
    void create_withNullRequest_throwsException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> reservationService.create(null))
                .isInstanceOf(NullPointerException.class);
    }

}
