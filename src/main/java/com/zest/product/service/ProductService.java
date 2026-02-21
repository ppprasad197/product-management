package com.zest.product.service;

import com.zest.product.entity.Product;
import com.zest.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found"
                        ));
    }

    public Product createProduct(Product product) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        product.setCreatedBy(username);
        product.setCreatedOn(LocalDateTime.now());

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updated) {

        Product existing = getProductById(id);

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        existing.setProductName(updated.getProductName());
        existing.setModifiedBy(username);
        existing.setModifiedOn(LocalDateTime.now());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
    }
}
