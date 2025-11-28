package com.accenture.training.hexagonaltutorial.hexagonal.domain.repository;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPortCommand {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
