package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;

import com.accenture.training.hexagonaltutorial.hexagonal.application.ports.IProductApplicationPortCommand;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductApplicationPortCommandImpl implements IProductApplicationPortCommand {

    private final ProductJpaRepositoryCommand productJpaRepositoryCommand;

    @Override
    public Product createProduct(Product product) {
        ProductHexaEntity productToSave = ProductEntityMapper.fromProductToEntity(product);
        return ProductEntityMapper.fromEntityToProduct(productJpaRepositoryCommand.save(productToSave));
    }

    @Override
    public Product updateProduct(Product product) {
        ProductHexaEntity productToSave = ProductEntityMapper.fromProductToEntity(product);
        return ProductEntityMapper.fromEntityToProduct(productJpaRepositoryCommand.save(productToSave));
    }

    @Override
    public void deleteProduct(String productId) {
        productJpaRepositoryCommand.deleteById(productId);
    }
}
