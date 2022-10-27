package com.devdelivery.orders.infrastructure.http.products;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ProductHttpClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ProductHttpErrorDecoder();
    }
}
