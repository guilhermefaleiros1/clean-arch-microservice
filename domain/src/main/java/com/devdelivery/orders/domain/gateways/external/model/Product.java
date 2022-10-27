package com.devdelivery.orders.domain.gateways.external.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
