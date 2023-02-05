package com.vsantos1.delivery.services;

import com.vsantos1.delivery.dtos.CategoryDTO;
import com.vsantos1.delivery.model.Category;
import com.vsantos1.delivery.repositories.CategoryRepository;
import com.vsantos1.delivery.services.gateways.CategoryGateway;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Category findById(Long id) {

        // TODO : Create custom exception
        return this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category execute(CategoryDTO categoryDTO) {
        Category category = new Category();

        mapper.map(categoryDTO, category);

        return this.categoryRepository.save(category);

    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category category = this.findById(id);

        mapper.map(categoryDTO, category);

        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {

        Category category = this.findById(id);

        this.categoryRepository.deleteById(category.getId());
    }
}
