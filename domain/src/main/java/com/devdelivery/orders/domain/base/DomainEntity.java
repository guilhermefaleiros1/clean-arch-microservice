package com.devdelivery.orders.domain.base;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class DomainEntity {
    private final UUID id;
}
