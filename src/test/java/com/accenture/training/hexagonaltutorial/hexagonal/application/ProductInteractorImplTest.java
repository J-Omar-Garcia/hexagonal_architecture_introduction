package com.accenture.training.hexagonaltutorial.hexagonal.application;

import com.accenture.training.hexagonaltutorial.hexagonal.application.adapters.ProductRepositoryPortQueryImpl;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.domain.ports.ProductRepositoryPortQuery;
import com.accenture.training.hexagonaltutorial.hexagonal.providers.ProductProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductInteractorImplTest {

    ProductRepositoryPortQuery productRepositoryPortQuery;

    @BeforeEach
    void setUp() {
        productRepositoryPortQuery = mock(ProductRepositoryPortQuery.class);
    }

    @ParameterizedTest
    @ArgumentsSource(ProductProvider.class)
    void getProductById_test(Product repositoryMockedProduct) {

        // given
        ProductRepositoryPortQueryImpl productInteractorImpl = new ProductRepositoryPortQueryImpl(productRepositoryPortQuery);

        when(productRepositoryPortQuery.findProductByProductId(anyString()))
                .thenReturn(repositoryMockedProduct);

        // when
        Product product = productInteractorImpl.findProductByProductId(repositoryMockedProduct.getProductId());

        // then
        verify(productRepositoryPortQuery, times(1)).findProductByProductId(repositoryMockedProduct.getProductId());
        assertEquals(repositoryMockedProduct, product);
    }

}
