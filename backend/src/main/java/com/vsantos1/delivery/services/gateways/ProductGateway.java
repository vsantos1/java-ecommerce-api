package com.vsantos1.delivery.services.gateways;

import com.vsantos1.delivery.dtos.ProductDTO;
import com.vsantos1.delivery.model.Product;
import com.vsantos1.delivery.repositories.filters.ProductQueryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {


    Product findById(UUID id);

    List<Product> findProductsByCategory(Long categoryId);

    Page<Product> findAllWithQuery(Pageable pageable, ProductQueryFilter productQueryFilter);

    Product execute(ProductDTO productDTO);

    Product update(UUID id, ProductDTO productDTO);

    void deleteById(UUID id);
}
