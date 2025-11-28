package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;


import com.accenture.training.hexagonaltutorial.hexagonal.application.ports.IProductApplicationPortQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ProductApplicationPortQueryImpl implements IProductApplicationPortQuery {

    private final ProductJpaRepositoryQuery productJpaRepositoryQuery;

    @Override
    public Product findProductById(String productId) {
        return productJpaRepositoryQuery.findByProductId(productId)
                .map(ProductEntityMapper::fromEntityToProduct)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }
}
