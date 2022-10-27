package com.devdelivery.orders.api.config;

import com.devdelivery.orders.domain.validation.Notification;
import com.devdelivery.orders.infrastructure.http.exceptions.HttpBadRequestException;
import com.devdelivery.orders.infrastructure.http.exceptions.HttpServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class OrdersExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<Notification> handleHttpBadRequestException(
            HttpBadRequestException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Notification.create(exception));
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Notification> handleHttpServerErrorException(
            HttpServerErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Notification.create(exception));
    }

}
