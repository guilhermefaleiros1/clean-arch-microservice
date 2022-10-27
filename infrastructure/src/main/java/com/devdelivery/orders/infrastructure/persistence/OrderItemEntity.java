package com.devdelivery.orders.infrastructure.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import com.devdelivery.orders.domain.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @Column
    private String description;

    public OrderItem toDomain() {
        return OrderItem.with(
                UUID.fromString(id),
                name,
                price,
                quantity,
                description
        );
    }

    public static OrderItemEntity from(final OrderItem order) {
        return OrderItemEntity.builder()
                .id(order.getId().toString())
                .name(order.getName())
                .description(order.getDescription())
                .price(order.getPrice().getValue())
                .quantity(order.getQuantity())
                .build();
    }
}
