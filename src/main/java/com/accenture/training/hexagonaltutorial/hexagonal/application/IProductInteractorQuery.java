package com.accenture.training.hexagonaltutorial.hexagonal.application;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

public interface IProductInteractorQuery {
    Product findProductById(String productId);
}
