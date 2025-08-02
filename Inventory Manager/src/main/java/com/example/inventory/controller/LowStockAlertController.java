package com.example.inventory.controller;

import com.example.inventory.dto.LowStockAlertResponse;
import com.example.inventory.service.LowStockAlertService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts/low-stock")
public class LowStockAlertController {
    private static final Logger logger = LoggerFactory.getLogger(LowStockAlertController.class);
    private final LowStockAlertService svc;

    public LowStockAlertController(LowStockAlertService svc) {
        this.svc = svc;
    }

    @GetMapping
    public ResponseEntity<List<LowStockAlertResponse>> list() {
        logger.info("Listing all low stock alerts");
        List<LowStockAlertResponse> alerts = svc.listAll();
        return ResponseEntity.ok(alerts);
    }
}
