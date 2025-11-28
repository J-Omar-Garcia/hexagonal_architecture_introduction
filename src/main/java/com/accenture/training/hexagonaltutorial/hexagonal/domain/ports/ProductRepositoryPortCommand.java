package com.accenture.training.hexagonaltutorial.hexagonal.domain.ports;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

public interface ProductRepositoryPortCommand {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
