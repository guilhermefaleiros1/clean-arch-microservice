package com.devdelivery.orders.api.controllers;

import java.util.function.Function;
import java.util.stream.Collectors;
import com.devdelivery.orders.api.models.CreateOrderRequest;
import com.devdelivery.orders.application.create.CreateOrder;
import com.devdelivery.orders.application.create.CreateOrderInput;
import com.devdelivery.orders.application.create.CreateOrderItemInput;
import com.devdelivery.orders.application.create.CreateOrderOutput;
import com.devdelivery.orders.domain.validation.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@Slf4j
public class 'OrderController {

    private final CreateOrder createOrder;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@RequestBody CreateOrderRequest request) {
        final var input = new CreateOrderInput(
                request.getItems().stream().map(item ->
                        new CreateOrderItemInput(item.getProductId(), item.getQuantity())).collect(
                        Collectors.toList())
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateOrderOutput, ResponseEntity<?>> onSuccess = output ->
                ResponseEntity.status(HttpStatus.CREATED).body(output);

        return this.createOrder.execute(input).fold(onError, onSuccess);
    }

}
