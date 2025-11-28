package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.rest.controller;

import com.accenture.training.hexagonaltutorial.common.PriceFormatter;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.mapper.ProductEntityMapper;
import com.accenture.training.hexagonaltutorial.hexagonal.providers.ProductEntityProvider;
import com.accenture.training.hexagonaltutorial.hexagonal.application.IProductInteractorQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.application.IProductInteractorCommand;
import com.accenture.training.hexagonaltutorial.common.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ProductRestController2Test {

    IProductInteractorQuery productInteractor;
    IProductInteractorCommand productInteractorCommand;
    ProductRestController productRestController;

    @BeforeEach
    void setUp() {
        productInteractor = mock(IProductInteractorQuery.class);
        productRestController = new ProductRestController(productInteractor,productInteractorCommand);
    }

    @ParameterizedTest
    @ArgumentsSource(ProductEntityProvider.class)
    void test(ProductHexaEntity mockedProductHexaEntity) {
        // given
        given(productInteractor.findProductById(mockedProductHexaEntity.getProductId())).willReturn(ProductEntityMapper.fromEntityToProduct(mockedProductHexaEntity));

        // when
        ProductDto productDto = productRestController.findProductByProductId(mockedProductHexaEntity.getProductId());

        // then
        verify(productInteractor, times(1)).findProductById(mockedProductHexaEntity.getProductId());
        assertEquals(mockedProductHexaEntity.getProductId(), productDto.getProductId());
        assertEquals(mockedProductHexaEntity.getName(), productDto.getName());
        assertEquals(mockedProductHexaEntity.getDescription(), productDto.getDescription());

        String readablePrice = PriceFormatter.formatPrice(mockedProductHexaEntity.getPrice(), mockedProductHexaEntity.getCurrency());
        assertEquals(readablePrice, productDto.getPrice());

    }

}
