package com.example.inventory.controller;

import com.example.inventory.dto.LocationRequest;
import com.example.inventory.dto.LocationResponse;
import com.example.inventory.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
    private final LocationService svc;

    public LocationController(LocationService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<LocationResponse> assign(@Valid @RequestBody LocationRequest req) {
        logger.info("Assigning location: {}", req);
        LocationResponse res = svc.create(req);
        return ResponseEntity.status(201).body(res);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<LocationResponse>> list(@PathVariable Long itemId) {
        List<LocationResponse> locations = svc.listByItem(itemId);
        return ResponseEntity.ok(locations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting location with id {}", id);
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
