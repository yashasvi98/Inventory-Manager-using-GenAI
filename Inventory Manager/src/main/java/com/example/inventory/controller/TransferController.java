package com.example.inventory.controller;

import com.example.inventory.dto.TransferRequest;
import com.example.inventory.dto.TransferResponse;
import com.example.inventory.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {
    private static final Logger logger = LoggerFactory.getLogger(TransferController.class);
    private final TransferService svc;

    public TransferController(TransferService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<TransferResponse> transfer(@Valid @RequestBody TransferRequest req) {
        logger.info("Transferring inventory: {}", req);
        TransferResponse res = svc.transfer(req);
        return ResponseEntity.ok(res);
    }
}
