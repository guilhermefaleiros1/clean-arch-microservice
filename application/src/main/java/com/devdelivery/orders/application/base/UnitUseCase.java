package com.devdelivery.orders.application.base;

public interface UnitUseCase<IN> {
    void execute(IN input);
}
