package com.accenture.training.hexagonaltutorial.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class  Product {
    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String currency;
}
