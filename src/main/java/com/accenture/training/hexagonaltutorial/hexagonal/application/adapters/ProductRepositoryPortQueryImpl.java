package com.accenture.training.hexagonaltutorial.hexagonal.application.adapters;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.ports.ProductRepositoryPortQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductRepositoryPortQueryImpl implements ProductRepositoryPortQuery {

    private final ProductRepositoryPortQuery productRepositoryQuery;

    @Override
    public Product findProductByProductId(String productId) {
        return productRepositoryQuery.findProductByProductId(productId);
    }
}
