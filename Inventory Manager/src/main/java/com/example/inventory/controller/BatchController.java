package com.example.inventory.controller;

import com.example.inventory.dto.BatchRequest;
import com.example.inventory.dto.BatchResponse;
import com.example.inventory.service.BatchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/batches")
public class BatchController {
    private static final Logger logger = LoggerFactory.getLogger(BatchController.class);
    private final BatchService svc;

    public BatchController(BatchService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<BatchResponse> create(@Valid @RequestBody BatchRequest req) {
        logger.info("Creating batch: {}", req);
        BatchResponse res = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
