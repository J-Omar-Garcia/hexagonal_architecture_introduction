package com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.repository;

import com.accenture.training.hexagonaltutorial.hexagonal.domain.model.Product;
import com.accenture.training.hexagonaltutorial.hexagonal.infrastructure.database.h2.entity.ProductHexaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductJpaRepositoryCommand extends JpaRepository<ProductHexaEntity, Long> {
    ProductHexaEntity save(ProductHexaEntity product);
    void deleteById(String id);
}
