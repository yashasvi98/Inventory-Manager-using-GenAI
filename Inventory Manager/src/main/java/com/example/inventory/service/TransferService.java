package com.example.inventory.service;

import com.example.inventory.dto.TransferRequest;
import com.example.inventory.dto.TransferResponse;
import com.example.inventory.entity.Transfer;
import com.example.inventory.mapper.TransferMapper;
import com.example.inventory.repository.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    private final TransferRepository repo;

    public TransferService(TransferRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public TransferResponse transfer(TransferRequest req) {
        // TODO: adjust source/dest stock
        Transfer t = TransferMapper.toEntity(req);
        Transfer saved = repo.save(t);
        return TransferMapper.toResponse(saved);
    }
}
