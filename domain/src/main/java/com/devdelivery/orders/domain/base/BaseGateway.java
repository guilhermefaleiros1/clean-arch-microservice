package com.devdelivery.orders.domain.base;

import java.util.List;
import java.util.Optional;

public interface BaseGateway <T extends DomainEntity> {
    T save(T entity);
    Optional<T> findById(String id);
    List<T> findAll();
    boolean deleteById(final String id);
}
