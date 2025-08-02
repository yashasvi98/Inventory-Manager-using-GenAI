package com.example.inventory.controller;

import com.example.inventory.dto.StockAdjustmentRequest;
import com.example.inventory.dto.StockAdjustmentResponse;
import com.example.inventory.service.StockAdjustmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-adjustments")
public class StockAdjustmentController {
    private static final Logger logger = LoggerFactory.getLogger(StockAdjustmentController.class);
    private final StockAdjustmentService svc;

    public StockAdjustmentController(StockAdjustmentService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<StockAdjustmentResponse> adjust(@Valid @RequestBody StockAdjustmentRequest req) {
        logger.info("Adjusting stock: {}", req);
        StockAdjustmentResponse res = svc.adjustStock(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<StockAdjustmentResponse>> list() {
        logger.info("Listing all stock adjustments");
        List<StockAdjustmentResponse> adjustments = svc.listAll();
        return ResponseEntity.ok(adjustments);
    }
}
