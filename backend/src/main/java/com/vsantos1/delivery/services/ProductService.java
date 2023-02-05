package com.vsantos1.delivery.services;

import com.vsantos1.delivery.dtos.ProductDTO;
import com.vsantos1.delivery.model.Category;
import com.vsantos1.delivery.model.Product;
import com.vsantos1.delivery.repositories.ProductRepository;
import com.vsantos1.delivery.repositories.filters.ProductQueryFilter;
import com.vsantos1.delivery.services.gateways.ProductGateway;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements ProductGateway {

    private final ModelMapper mapper;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public ProductService(ModelMapper mapper, CategoryService categoryService, ProductRepository productRepository) {
        this.mapper = mapper;
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(UUID id) {
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> findProductsByCategory(Long categoryId) {
        return this.productRepository.findProductsByCategory_Id(categoryId);
    }

    @Override
    public Page<Product> findAllWithQuery(Pageable pageable, ProductQueryFilter productQueryFilter) {
        return this.productRepository.findProductsByNameOrDescriptionIgnoreCase(pageable, productQueryFilter.getName(), productQueryFilter.getDescription());
    }

    @Override
    public Product execute(ProductDTO productDTO) {
        this.categoryService.findById(productDTO.getCategory().getId());
        Product product = new Product();

        mapper.map(productDTO, product);

        return this.productRepository.save(product);
    }

    @Override
    public Product update(UUID id, ProductDTO productDTO) {
        Category category = this.categoryService.findById(productDTO.getCategory().getId());
        Product product = new Product();
        productDTO.setCategory(category);
        mapper.map(productDTO, product);

        return this.productRepository.save(product);
    }

    @Override
    public void deleteById(UUID id) {
        Product product = this.findById(id);

        this.productRepository.deleteById(product.getId());
    }
}
