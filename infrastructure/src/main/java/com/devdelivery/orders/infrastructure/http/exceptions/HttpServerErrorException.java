package com.devdelivery.orders.infrastructure.http.exceptions;

public class HttpServerErrorException extends RuntimeException {
    public HttpServerErrorException(String message) {
        super(message);
    }
}
