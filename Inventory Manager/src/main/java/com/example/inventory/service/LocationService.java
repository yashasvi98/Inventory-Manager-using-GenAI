package com.example.inventory.service;

import com.example.inventory.dto.LocationRequest;
import com.example.inventory.dto.LocationResponse;
import com.example.inventory.entity.Location;
import com.example.inventory.mapper.LocationMapper;
import com.example.inventory.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository repo;

    public LocationService(LocationRepository repo) {
        this.repo = repo;
    }

    public LocationResponse create(LocationRequest req) {
        Location l = repo.save(LocationMapper.toEntity(req));
        return LocationMapper.toResponse(l);
    }

    public List<LocationResponse> listByItem(Long itemId) {
        return repo.findByItemId(itemId).stream()
                   .map(LocationMapper::toResponse)
                   .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
