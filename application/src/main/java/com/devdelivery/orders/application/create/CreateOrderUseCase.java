package com.devdelivery.orders.application.create;

import com.devdelivery.orders.application.base.UseCase;
import com.devdelivery.orders.domain.validation.Notification;
import io.vavr.control.Either;

public interface CreateOrderUseCase extends UseCase<CreateOrderInput, Either<Notification, CreateOrderOutput>> {
}
