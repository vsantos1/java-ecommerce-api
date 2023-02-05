package com.vsantos1.delivery.repositories;

import com.vsantos1.delivery.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findProductsByCategory_Id(Long categoryId);

    Page<Product> findProductsByNameOrDescriptionIgnoreCase(Pageable pageable, String name, String description);
}
