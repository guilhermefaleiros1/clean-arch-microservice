package com.devdelivery.orders.domain.valueobjects;

import java.math.BigDecimal;
import com.devdelivery.orders.domain.base.ValueObject;
import lombok.Getter;

@Getter
public class Money extends ValueObject {
    private final BigDecimal value;
    private final Currency currency;

    private Money(final BigDecimal value, final Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money newMoney(final BigDecimal value, final Currency currency) {
        return new Money(value, currency);
    }

    public String printFormatted() {
        return this.getCurrency().getSymbol() + " " + this.value;
    }
}
