package com.example.inventory.service;

import com.example.inventory.dto.LowStockAlertResponse;
import com.example.inventory.mapper.LowStockAlertMapper;
import com.example.inventory.repository.LowStockAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LowStockAlertService {
    private final LowStockAlertRepository repo;

    public LowStockAlertService(LowStockAlertRepository repo) {
        this.repo = repo;
    }

    public List<LowStockAlertResponse> listAll() {
        return repo.findAll().stream()
                   .map(LowStockAlertMapper::toResponse)
                   .collect(Collectors.toList());
    }
}
