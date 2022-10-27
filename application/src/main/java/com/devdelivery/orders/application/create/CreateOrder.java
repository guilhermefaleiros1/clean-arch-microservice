package com.devdelivery.orders.application.create;

import javax.inject.Named;
import java.util.stream.Collectors;
import com.devdelivery.orders.domain.entities.Order;
import com.devdelivery.orders.domain.entities.OrderItem;
import com.devdelivery.orders.domain.gateways.external.ProductGateway;
import com.devdelivery.orders.domain.gateways.internal.OrderGateway;
import com.devdelivery.orders.domain.validation.BusinessError;
import com.devdelivery.orders.domain.validation.Notification;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

@Named
@RequiredArgsConstructor
public class CreateOrder implements CreateOrderUseCase {

    private final OrderGateway orderGateway;

    private final ProductGateway productGateway;

    @Override
    public Either<Notification, CreateOrderOutput> execute(CreateOrderInput input) {
        Notification notification = Notification.create();

        final var orderItems = input.items().stream().map(item ->
                this.processOrderItem(notification, item)).collect(Collectors.toList());

        if (notification.hasError()) {
            return Left(notification);
        }

        final var order = Order.newOrder(orderItems);
        order.validate(notification);

        if (notification.hasError()) {
            return Left(notification);
        }

        return Try(() -> this.orderGateway.save(order))
                .toEither()
                .bimap(Notification::create, CreateOrderOutput::from);
    }

    private OrderItem processOrderItem(final Notification notification, final CreateOrderItemInput item) {
        final var productId = item.productId();
        final var productOptional = productGateway.findById(productId);
        if (productOptional.isEmpty()) {
            notification.append(new BusinessError(String.format("Product of id: %s is not available", productId)));
            return null;
        } else {
            final var product = productOptional.get();
            return OrderItem.newOrderItem(product.getName(),
                    product.getPrice(), item.quantity(), product.getDescription());
        }
    }
}
