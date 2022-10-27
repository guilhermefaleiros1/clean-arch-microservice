package com.devdelivery.orders.domain.valueobjects;

public enum Currency {
    REAL("R$");

    private final String symbol;

    Currency(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
