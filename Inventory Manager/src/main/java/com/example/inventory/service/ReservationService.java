package com.example.inventory.service;

import com.example.inventory.dto.ReservationRequest;
import com.example.inventory.dto.ReservationResponse;
import com.example.inventory.entity.Reservation;
import com.example.inventory.mapper.ReservationMapper;
import com.example.inventory.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class ReservationService {
    private final ReservationRepository repo;

    public ReservationService(ReservationRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public ReservationResponse reserve(ReservationRequest req) {
        Reservation r = ReservationMapper.toEntity(req);
        r.setReservedAt(Instant.now());
        r.setExpiresAt(Instant.now().plusSeconds(900)); // 15 min
        Reservation saved = repo.save(r);
        return ReservationMapper.toResponse(saved);
    }
}
