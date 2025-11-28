package com.accenture.training.hexagonaltutorial.hexagonal.domain.ports;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;


public interface ProductRepositoryPortQuery{

    Product findProductByProductId(String productId);

}
