package com.vsantos1.delivery.services.gateways;

import com.vsantos1.delivery.dtos.CategoryDTO;
import com.vsantos1.delivery.model.Category;

import java.util.List;

public interface CategoryGateway {

    Category findById(Long id);

    List<Category> findAll();

    Category execute(CategoryDTO categoryDTO);

    Category update(Long id, CategoryDTO categoryDTO);

    void deleteById(Long id);
}
