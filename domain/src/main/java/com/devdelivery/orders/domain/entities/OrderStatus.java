package com.devdelivery.orders.domain.entities;

public enum OrderStatus {
    DRAFT,
    REQUESTED,
    CONFIRMED,
    PREPARING,
    CANCELED,
    DELIVERING,
    FINISHED
}
