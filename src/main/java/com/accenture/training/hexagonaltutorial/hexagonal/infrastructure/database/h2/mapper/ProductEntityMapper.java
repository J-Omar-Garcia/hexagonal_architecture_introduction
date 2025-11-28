package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;

import java.util.Optional;

public class ProductEntityMapper {

    public static Product fromEntityToProduct(ProductHexaEntity productHexaEntity) {
        return new Product(productHexaEntity.getProductId(),
                           productHexaEntity.getName(),
                           productHexaEntity.getDescription(),
                           productHexaEntity.getPrice(),
                           productHexaEntity.getCurrency()
        );
    }

    public static ProductHexaEntity fromProductToEntity(Product product) {
        return new ProductHexaEntity(product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCurrency()
        );
    }

}
