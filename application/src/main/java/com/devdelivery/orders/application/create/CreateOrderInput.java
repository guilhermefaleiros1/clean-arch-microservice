package com.devdelivery.orders.application.create;

import java.util.List;

public record CreateOrderInput(
        List<CreateOrderItemInput> items
) {
}
