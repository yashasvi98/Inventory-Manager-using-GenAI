package com.example.inventory.service;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.dto.ItemResponse;
import com.example.inventory.entity.Item;
import com.example.inventory.mapper.ItemMapper;
import com.example.inventory.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public ItemResponse create(ItemRequest req) {
        logger.info("Attempting to create item with SKU: {}", req.getSku());
        if (repo.existsBySku(req.getSku())) {
            logger.warn("SKU already exists: {}", req.getSku());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "SKU already exists");
        }
        Item i = ItemMapper.toEntity(req);
        i.setCreatedAt(Instant.now());
        i.setUpdatedAt(Instant.now());
        Item saved = repo.save(i);
        logger.info("Created item with ID: {}", saved.getId());
        return ItemMapper.toResponse(saved);
    }

    public List<ItemResponse> listAll() {
        List<Item> items = repo.findAll();
        logger.debug("Listing all items, count: {}", items.size());
        return items.stream()
                   .map(ItemMapper::toResponse)
                   .collect(Collectors.toList());
    }

    public ItemResponse getById(Long id) {
        logger.debug("Fetching item by ID: {}", id);
        Item i = repo.findById(id)
                     .orElseThrow(() -> {
                         logger.warn("Item not found with ID: {}", id);
                         return new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
                     });
        return ItemMapper.toResponse(i);
    }

    public ItemResponse update(Long id, ItemRequest req) {
        logger.info("Updating item with ID: {}", id);
        Item existing = repo.findById(id)
                            .orElseThrow(() -> {
                                logger.warn("Item not found for update, ID: {}", id);
                                return new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
                            });
        if (!existing.getSku().equals(req.getSku()) && repo.existsBySku(req.getSku())) {
            logger.warn("SKU conflict on update. Existing SKU: {}, New SKU: {}", existing.getSku(), req.getSku());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "SKU already exists");
        }
        existing.setName(req.getName());
        existing.setDescription(req.getDescription());
        existing.setSku(req.getSku());
        existing.setCategoryId(req.getCategoryId());
        existing.setSupplierId(req.getSupplierId());
        existing.setUpdatedAt(Instant.now());
        Item updated = repo.save(existing);
        logger.info("Updated item with ID: {}", updated.getId());
        return ItemMapper.toResponse(updated);
    }

    public void delete(Long id) {
        logger.info("Attempting to delete item with ID: {}", id);
        if (!repo.existsById(id)) {
            logger.warn("Item not found for deletion, ID: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
        repo.deleteById(id);
        logger.info("Deleted item with ID: {}", id);
    }
}
