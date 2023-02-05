package com.vsantos1.delivery.repositories;

import com.vsantos1.delivery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
