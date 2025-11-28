package com.accenture.training.hexagonaltutorial.hexagonal.domain.repository;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import org.springframework.stereotype.Component;


public interface ProductRepositoryPortQuery{

    Product findProductByProductId(String productId);

}
