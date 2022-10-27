package com.devdelivery.orders.infrastructure.http.exceptions;

public class HttpUnprocessableEntityException extends RuntimeException {
    public HttpUnprocessableEntityException(String message) {
        super(message);
    }
}
