package com.devdelivery.orders.domain.exceptions;

import java.util.List;
import com.devdelivery.orders.domain.validation.BusinessError;

public class DomainException extends RuntimeException {

    protected final List<BusinessError> errors;

    protected DomainException(final String message, final List<BusinessError> errors) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final BusinessError errors) {
        return new DomainException(errors.message(), List.of(errors));
    }

    public static DomainException with(final List<BusinessError> errors) {
        return new DomainException("", errors);
    }

    public List<BusinessError> getErrors() {
        return errors;
    }
}