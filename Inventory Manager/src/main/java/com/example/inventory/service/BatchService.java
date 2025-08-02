package com.example.inventory.service;

import com.example.inventory.dto.BatchRequest;
import com.example.inventory.dto.BatchResponse;
import com.example.inventory.entity.Batch;
import com.example.inventory.mapper.BatchMapper;
import com.example.inventory.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BatchService {
    private final BatchRepository repo;

    public BatchService(BatchRepository repo) {
        this.repo = repo;
    }

    public BatchResponse create(BatchRequest req) {
        if (req.getExpiryDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be in the future");
        }
        Batch b = repo.save(BatchMapper.toEntity(req));
        return BatchMapper.toResponse(b);
    }
}
