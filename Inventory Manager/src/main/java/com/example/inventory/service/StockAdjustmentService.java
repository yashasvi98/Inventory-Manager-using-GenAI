package com.example.inventory.service;

import com.example.inventory.dto.StockAdjustmentRequest;
import com.example.inventory.dto.StockAdjustmentResponse;
import com.example.inventory.entity.StockAdjustment;
import com.example.inventory.mapper.StockAdjustmentMapper;
import com.example.inventory.repository.StockAdjustmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockAdjustmentService {
    private final StockAdjustmentRepository repo;

    public StockAdjustmentService(StockAdjustmentRepository repo) {
        this.repo = repo;
    }

    public StockAdjustmentResponse adjustStock(StockAdjustmentRequest req) {
        StockAdjustment sa = repo.save(StockAdjustmentMapper.toEntity(req));
        return StockAdjustmentMapper.toResponse(sa);
    }

    public List<StockAdjustmentResponse> listAll() {
        return repo.findAll().stream()
                   .map(StockAdjustmentMapper::toResponse)
                   .collect(Collectors.toList());
    }
}
