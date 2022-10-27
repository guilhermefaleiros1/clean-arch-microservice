package com.devdelivery.orders.application.create;

public record CreateOrderItemInput(
        String productId,
        Integer quantity
) {
}
