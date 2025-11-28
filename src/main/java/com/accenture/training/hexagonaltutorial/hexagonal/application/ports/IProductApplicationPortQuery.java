package com.accenture.training.hexagonaltutorial.hexagonal.application.ports;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

public interface IProductApplicationPortQuery {
    Product findProductById(String productId);
}
