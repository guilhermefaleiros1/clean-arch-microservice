package com.devdelivery.orders.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;
import com.devdelivery.orders.domain.base.DomainEntity;
import com.devdelivery.orders.domain.valueobjects.Currency;
import com.devdelivery.orders.domain.valueobjects.Money;
import lombok.Getter;

@Getter
public class OrderItem extends DomainEntity {
    private final String name;
    private final Money price;
    private final Integer quantity;
    private final String description;

    private OrderItem(final UUID id, final String name, Money price,
                     final Integer quantity, final String description) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public static OrderItem newOrderItem(
        final String name,
        final BigDecimal price,
        final Integer quantity,
        final String description
    ) {
        final var id = UUID.randomUUID();
        return new OrderItem(id, name, Money.newMoney(price, Currency.REAL), quantity, description);
    }

    public static OrderItem with(
        final UUID id,
        final String name,
        final BigDecimal price,
        final Integer quantity,
        final String description
    ) {
        return new OrderItem(id, name, Money.newMoney(price, Currency.REAL), quantity, description);
    }
}
