package com.devdelivery.orders.application.base;

public interface UseCase <IN, OUT>{
    OUT execute(IN input);
}
