package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.mapper;

import com.accenture.training.hexagonaltutorial.common.ProductDto;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;

import java.math.BigDecimal;

public class ProductDtoMapper {

    public static ProductDto fromProductToDto(Product product) {
        return new ProductDto(product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCurrency()
        );
    }

    public static Product fromDtoToProduct(ProductDto productDto) {
        return new Product(productDto.getProductId(),
                productDto.getName(),
                productDto.getDescription(),
                BigDecimal.valueOf(Long.parseLong(productDto.getPrice())),
                productDto.getCurrency()

        );
    }

}
