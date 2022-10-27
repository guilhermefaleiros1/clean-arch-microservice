package com.devdelivery.orders.domain.validation;

import java.util.ArrayList;
import java.util.List;
import com.devdelivery.orders.domain.exceptions.DomainException;

public class Notification implements ValidationHandler {

    private final List<BusinessError> errors;

    private Notification(final List<BusinessError> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Throwable t) {
        return create(new BusinessError(t.getMessage()));
    }

    public static Notification create(final BusinessError error) {
        return new Notification(new ArrayList<>()).append(error);
    }

    @Override
    public Notification append(final BusinessError error) {
        this.errors.add(error);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler handler) {
        this.errors.addAll(handler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(final Validation<T> validation) {
        try {
            return validation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new BusinessError(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<BusinessError> getErrors() {
        return this.errors;
    }
}
