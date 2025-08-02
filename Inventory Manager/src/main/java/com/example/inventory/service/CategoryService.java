package com.example.inventory.service;

import com.example.inventory.dto.CategoryRequest;
import com.example.inventory.dto.CategoryResponse;
import com.example.inventory.entity.Category;
import com.example.inventory.mapper.CategoryMapper;
import com.example.inventory.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public CategoryResponse create(CategoryRequest req) {
        if (repo.existsByName(req.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists");
        }
        Category c = repo.save(CategoryMapper.toEntity(req));
        return CategoryMapper.toResponse(c);
    }

    public List<CategoryResponse> list() {
        return repo.findAll().stream()
                   .map(CategoryMapper::toResponse)
                   .collect(Collectors.toList());
    }

    public CategoryResponse get(Long id) {
        Category c = repo.findById(id)
                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        return CategoryMapper.toResponse(c);
    }
}
