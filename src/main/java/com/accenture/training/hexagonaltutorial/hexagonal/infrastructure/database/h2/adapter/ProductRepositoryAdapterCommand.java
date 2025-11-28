package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.repository.ProductRepositoryPortCommand;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryCommand;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapterCommand  implements ProductRepositoryPortCommand {

    private final ProductJpaRepositoryCommand productJpaRepositoryCommand;

    @Override
    public Product createProduct(Product product) {

        return ProductEntityMapper.fromEntityToProduct(
                productJpaRepositoryCommand.save(ProductEntityMapper.fromProductToEntity(product)));
    }

    @Override
    public Product updateProduct(Product product) {
       return  ProductEntityMapper.fromEntityToProduct(
                productJpaRepositoryCommand.save(ProductEntityMapper.fromProductToEntity(product)));
    }

    @Override
    public void deleteProduct(String id) {
        productJpaRepositoryCommand.deleteById(id);
    }
}
