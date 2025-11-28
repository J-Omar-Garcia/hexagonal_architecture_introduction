package com.accenture.training.hexagonaltutorial.hexagonal.application;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

import java.util.UUID;

public interface IProductInteractorCommand {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String productId);

}
