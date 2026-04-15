package com.novashop.api.controller;

import com.novashop.api.dto.CategoryRequest;
import com.novashop.api.model.Category;
import com.novashop.api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category create(@Valid @RequestBody CategoryRequest request) {
        return categoryService.create(request);
    }
}
