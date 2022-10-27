package com.devdelivery.orders.domain.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.devdelivery.orders.domain.base.DomainEntity;
import com.devdelivery.orders.domain.validation.ValidationHandler;
import com.devdelivery.orders.domain.validation.validators.OrderValidator;
import lombok.Getter;

@Getter
public class Order extends DomainEntity {
    private final List<OrderItem> items;
    private OrderStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Order(final UUID id, final List<OrderItem> items, final OrderStatus status, final LocalDateTime createdAt,
                 final LocalDateTime updatedAt) {
        super(id);
        this.items = items;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Order newOrder(final List<OrderItem> items) {
        final var id = UUID.randomUUID();
        return new Order(id, items, OrderStatus.DRAFT, LocalDateTime.now(), LocalDateTime.now());
    }

    public static Order with(final UUID id, final List<OrderItem> items, final OrderStatus status,
                             final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        return new Order(id, items, status, createdAt, updatedAt);
    }

    public void validate(final ValidationHandler handler) {
        new OrderValidator(this, handler).validate();
    }

    public void request() {
        this.status = OrderStatus.REQUESTED;
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        this.status = OrderStatus.CANCELED;
        this.updatedAt = LocalDateTime.now();
    }

    public void confirm() {
        this.status = OrderStatus.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }

    public void preparing() {
        this.status = OrderStatus.PREPARING;
        this.updatedAt = LocalDateTime.now();
    }

    public void delivering() {
        this.status = OrderStatus.DELIVERING;
        this.updatedAt = LocalDateTime.now();
    }

    public void finish() {
        this.status = OrderStatus.FINISHED;
        this.updatedAt = LocalDateTime.now();
    }

}
