package com.accenture.training.hexagonaltutorial.hexagonal.application.adapters;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.ports.ProductRepositoryPortCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ProductRepositoryPortCommandImpl implements ProductRepositoryPortCommand{

    private final ProductRepositoryPortCommand productRepositoryPortCommand;

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPortCommand.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepositoryPortCommand.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepositoryPortCommand.deleteProduct(productId);

    }
}
