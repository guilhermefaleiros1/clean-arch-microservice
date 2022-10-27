package com.devdelivery.orders.infrastructure.http.products;

import java.util.Optional;
import com.devdelivery.orders.domain.gateways.external.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "producthttpclient", url = "http://localhost:8080/api",
        configuration = ProductHttpClientConfig.class)
public interface ProductHttpClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}", produces = "application/json")
    Optional<Product> getById(@PathVariable("id") String id);

}
