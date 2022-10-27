package com.devdelivery.orders.infrastructure.http.products;

import com.devdelivery.orders.infrastructure.http.exceptions.HttpBadRequestException;
import com.devdelivery.orders.infrastructure.http.exceptions.HttpServerErrorException;
import com.devdelivery.orders.infrastructure.http.exceptions.HttpUnprocessableEntityException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ProductHttpErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new HttpBadRequestException("Bad request on product service call");
            case 404:
                return new ProductNotFoundException("Product not found");
            case 422:
                return new HttpUnprocessableEntityException("Invalid request sent to product service");
            default:
                return new HttpServerErrorException("Unexpected error to access product service");
        }
    }
}
