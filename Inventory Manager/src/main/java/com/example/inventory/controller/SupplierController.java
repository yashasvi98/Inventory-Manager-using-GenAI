package com.example.inventory.controller;

import com.example.inventory.dto.SupplierRequest;
import com.example.inventory.dto.SupplierResponse;
import com.example.inventory.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
    private final SupplierService svc;

    public SupplierController(SupplierService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> create(@Valid @RequestBody SupplierRequest req) {
        logger.info("Creating supplier: {}", req);
        SupplierResponse res = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> list() {
        List<SupplierResponse> suppliers = svc.list();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> get(@PathVariable Long id) {
        SupplierResponse res = svc.get(id);
        return ResponseEntity.ok(res);
    }
}
