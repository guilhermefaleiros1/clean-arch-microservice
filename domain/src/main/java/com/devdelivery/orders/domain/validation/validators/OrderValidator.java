package com.devdelivery.orders.domain.validation.validators;

import com.devdelivery.orders.domain.entities.Order;
import com.devdelivery.orders.domain.validation.ValidationHandler;
import com.devdelivery.orders.domain.validation.Validator;

public class OrderValidator extends Validator {
    private final Order order;

    public OrderValidator(final Order order, final ValidationHandler handler) {
        super(handler);
        this.order = order;
    }

    @Override
    public void validate() {

    }
}
