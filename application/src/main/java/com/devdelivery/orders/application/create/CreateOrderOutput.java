package com.devdelivery.orders.application.create;

import java.time.LocalDateTime;
import com.devdelivery.orders.domain.entities.Order;
import com.devdelivery.orders.domain.entities.OrderStatus;

public record CreateOrderOutput(
        String id,
        OrderStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static CreateOrderOutput from(final Order order) {
        return new CreateOrderOutput(order.getId().toString(), order.getStatus(), order.getCreatedAt(), order.getUpdatedAt());
    }


}
