package com.example.inventory.service;

import com.example.inventory.dto.SupplierRequest;
import com.example.inventory.dto.SupplierResponse;
import com.example.inventory.entity.Supplier;
import com.example.inventory.mapper.SupplierMapper;
import com.example.inventory.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    private final SupplierRepository repo;

    public SupplierService(SupplierRepository repo) {
        this.repo = repo;
    }

    public SupplierResponse create(SupplierRequest req) {
        Supplier s = repo.save(SupplierMapper.toEntity(req));
        return SupplierMapper.toResponse(s);
    }

    public List<SupplierResponse> list() {
        return repo.findAll().stream()
                   .map(SupplierMapper::toResponse)
                   .collect(Collectors.toList());
    }

    public SupplierResponse get(Long id) {
        Supplier s = repo.findById(id)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
        return SupplierMapper.toResponse(s);
    }
}
