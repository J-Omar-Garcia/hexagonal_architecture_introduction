package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.controller;

import com.accenture.training.hexagonaltutorial.hexagonal.application.IProductInteractorCommand;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.mapper.ProductDtoMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.application.IProductInteractorQuery;
import com.accenture.training.hexagonaltutorial.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/hexagonal/products")
@RestController
public class ProductRestController {

    private final IProductInteractorQuery productInteractor;
    private final IProductInteractorCommand productInteractorCommand;

    @GetMapping("/{productId}")
    public ProductDto findProductByProductId(@PathVariable String productId) {
        return ProductDtoMapper.fromProductToDto(productInteractor.findProductById(productId));
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
