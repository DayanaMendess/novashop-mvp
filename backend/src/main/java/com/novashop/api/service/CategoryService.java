package com.novashop.api.service;

import com.novashop.api.dto.CategoryRequest;
import com.novashop.api.model.Category;
import com.novashop.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(CategoryRequest request) {
        Category category = new Category(request.getName(), request.getDescription());
        return categoryRepository.save(category);
    }
}
