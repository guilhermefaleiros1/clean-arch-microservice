package com.devdelivery.orders.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import com.devdelivery.orders.domain.entities.Order;
import com.devdelivery.orders.domain.gateways.internal.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository implements OrderGateway {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order save(Order order) {
        return this.orderJpaRepository.save(OrderEntity.from(order)).toDomain();
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
