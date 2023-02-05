package com.vsantos1.delivery.resources;

import com.electronwill.nightconfig.core.conversion.Path;
import com.vsantos1.delivery.dtos.ProductDTO;
import com.vsantos1.delivery.model.Product;
import com.vsantos1.delivery.repositories.filters.ProductQueryFilter;
import com.vsantos1.delivery.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<Page<Product>> getAllProducts(@PageableDefault Pageable pageable, @RequestParam(value = "q", required = false) ProductQueryFilter query) {

        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllWithQuery(pageable, query));
    }

    @GetMapping(value = "/products/{product_id}")
    public ResponseEntity<Product> getById(@PathVariable("product_id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @GetMapping(value = "/products/categories/{category_id}")
    public ResponseEntity<List<Product>> getByCategoryId(@PathVariable("category_id") Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsByCategory(categoryId));

    }

    @PostMapping(value = "/products", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> create(@ModelAttribute @Valid ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.execute(productDTO));
    }


    @PutMapping(value = "/products/{product_id}")
    public ResponseEntity<Product> update(@PathVariable("product_id") UUID id, @ModelAttribute ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(id, productDTO));
    }

    @DeleteMapping(value = "/products/{product_id}")
    public ResponseEntity<Void> delete(@PathVariable("product_id") UUID id) {

        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
