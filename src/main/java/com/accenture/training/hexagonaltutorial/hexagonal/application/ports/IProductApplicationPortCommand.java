package com.accenture.training.hexagonaltutorial.hexagonal.application.ports;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

public interface IProductApplicationPortCommand {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String productId);

}
