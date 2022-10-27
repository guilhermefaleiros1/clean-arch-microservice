package com.devdelivery.orders.infrastructure.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.devdelivery.orders.domain.entities.Order;
import com.devdelivery.orders.domain.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private String id;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> items;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    public Order toDomain() {
        return Order.with(
                UUID.fromString(id),
                items.stream().map(OrderItemEntity::toDomain).collect(Collectors.toList()),
                status,
                createdAt,
                updatedAt
        );
    }

    public static OrderEntity from(final Order order) {
        return OrderEntity.builder()
                .id(order.getId().toString())
                .status(order.getStatus())
                .items(order.getItems().stream().map(OrderItemEntity::from).collect(Collectors.toList()))
                .updatedAt(order.getUpdatedAt())
                .createdAt(order.getCreatedAt())
                .build();
    }

}
