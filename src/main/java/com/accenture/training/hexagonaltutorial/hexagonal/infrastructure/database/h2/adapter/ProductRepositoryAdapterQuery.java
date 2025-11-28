package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;


import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPortQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapterQuery implements ProductRepositoryPortQuery {

    private final ProductJpaRepositoryQuery productJpaRepositoryQuery;

    @Override
    public Product findProductByProductId(String productId) {
        return productJpaRepositoryQuery.findByProductId(productId)  // devuelve un Optional<ProductHexaEntity>
                .map(ProductEntityMapper::fromEntityToProduct)  // usamos el map de optional para convertir nuestro ProductHexaEntity a nuestro Product (modelo)
                .orElseThrow(() -> new NoSuchElementException("Product not found")); // si no hay elemento presente (dentro del optional), devolvemos una excepción
    }


}
