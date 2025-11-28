package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.adapter;

import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository.ProductJpaRepositoryQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.providers.ProductEntityProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductRepositoryPortCommandAdapterTest {


    ProductJpaRepositoryQuery productJpaRepositoryQuery;

    @BeforeEach
    void setUp() {
        productJpaRepositoryQuery = mock(ProductJpaRepositoryQuery.class);
    }

    @ParameterizedTest
    @ArgumentsSource(ProductEntityProvider.class)
    void findProductByProductId(ProductHexaEntity productHexaEntity) {
        //GIVEN
        ProductRepositoryAdapterQuery productRepositoryAdapter = new ProductRepositoryAdapterQuery(productJpaRepositoryQuery);
        given(productJpaRepositoryQuery.findByProductId(productHexaEntity.getProductId())).willReturn(Optional.of(productHexaEntity));
        //WHEN
        Product product = productRepositoryAdapter.findProductByProductId(productHexaEntity.getProductId());
        //THEN
        assertEquals(productHexaEntity.getProductId(), product.getProductId());
        assertEquals(productHexaEntity.getName(), product.getName());
        assertEquals(productHexaEntity.getDescription(), product.getDescription());
        assertEquals(productHexaEntity.getPrice(), product.getPrice());
        assertEquals(productHexaEntity.getCurrency(), product.getCurrency());
    }
}