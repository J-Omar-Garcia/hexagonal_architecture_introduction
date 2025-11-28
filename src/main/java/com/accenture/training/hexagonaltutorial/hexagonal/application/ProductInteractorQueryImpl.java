package com.accenture.training.hexagonaltutorial.hexagonal.application;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPortQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductInteractorQueryImpl implements IProductInteractorQuery {

    private final ProductRepositoryPortQuery productRepositoryQuery;

    @Override
    public Product findProductById(String productId) {
        return productRepositoryQuery.findProductByProductId(productId);
    }
}
