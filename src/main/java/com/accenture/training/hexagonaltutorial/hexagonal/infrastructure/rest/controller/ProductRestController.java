package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.controller;

import com.accenture.training.hexagonaltutorial.hexagonal.application.adapters.ProductRepositoryPortCommandImpl;
import com.accenture.training.hexagonaltutorial.hexagonal.application.adapters.ProductRepositoryPortQueryImpl;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.mapper.ProductDtoMapper;
import com.accenture.training.hexagonaltutorial.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/hexagonal/products")
@RestController
public class ProductRestController {

    private final ProductRepositoryPortQueryImpl productInteractor;
    private final ProductRepositoryPortCommandImpl productInteractorCommand;

    @GetMapping("/{productId}")
    public ProductDto findProductByProductId(@PathVariable String productId) {
        return ProductDtoMapper.fromProductToDto(productInteractor.findProductByProductId(productId));
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return ProductDtoMapper.fromProductToDto(productInteractorCommand.createProduct(ProductDtoMapper.fromDtoToProduct(productDto)));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return ProductDtoMapper.fromProductToDto(productInteractorCommand.updateProduct(ProductDtoMapper.fromDtoToProduct(productDto)));
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable String productId) {
        productInteractorCommand.deleteProduct(productId);
    }
}
