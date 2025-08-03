package com.example.inventory.repository;

import com.example.inventory.entity.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReservationRepositoryTest {
    @Autowired
    private ReservationRepository repo;

    @Test
    void saveAndFindById() {
        Reservation r = Reservation.builder().itemId(1L).quantity(2).reservedFor("User1").build();
        Reservation saved = repo.save(r);
        assertThat(saved.getId()).isNotNull();
        Reservation found = repo.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getReservedFor()).isEqualTo("User1");
    }

    @Test
    void deleteById() {
        Reservation r = Reservation.builder().itemId(2L).quantity(3).reservedFor("User2").build();
        Reservation saved = repo.save(r);
        repo.deleteById(saved.getId());
        assertThat(repo.findById(saved.getId())).isEmpty();
    }
}
