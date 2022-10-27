package com.devdelivery.orders.domain.gateways.external;

import java.util.Optional;
import com.devdelivery.orders.domain.gateways.external.model.Product;

public interface ProductGateway {
    Optional<Product> findById(final String id);
}
