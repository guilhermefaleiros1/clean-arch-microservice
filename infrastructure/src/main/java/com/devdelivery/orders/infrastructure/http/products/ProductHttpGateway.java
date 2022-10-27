package com.devdelivery.orders.infrastructure.http.products;

import java.util.Optional;
import com.devdelivery.orders.domain.gateways.external.ProductGateway;
import com.devdelivery.orders.domain.gateways.external.model.Product;
import com.devdelivery.orders.infrastructure.http.exceptions.HttpServerErrorException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductHttpGateway implements ProductGateway {
    private static final String LOG_TAG = "[ProductHttpGateway]";

    private final ProductHttpClient productHttpClient;

    @Override
    @Cacheable(value = "product", key = "#id")
    public Optional<Product> findById(String id) {
        try {
            log.info("{} Requesting products service with id: {}", LOG_TAG, id);
            return this.productHttpClient.getById(id);
        } catch (final ProductNotFoundException exception) {
            log.info("{} Product not found, returning empty...", LOG_TAG);
            return Optional.empty();
        } catch (final FeignException exception) {
            log.error("{} Unexpected to request with product service http, message: {}",
                    LOG_TAG, exception.getMessage());
            throw new HttpServerErrorException("Unexpected error on make http request to product service");
        }
    }
}
