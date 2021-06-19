package com.tng.oss.pfk.infrastructure.core.error;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

public class GenericException extends RuntimeException {
    private final GenericExceptionError error;

    public GenericException(@NotNull GenericCategorizedError error, String message) {
        super(message);
        Assert.notNull(error, "Provided error cannot be null!");
        this.error = StandardExceptionError.of(error, message);
    }

    public GenericException(@NotNull GenericCategorizedError error, String message, Throwable cause) {
        super(message, cause);
        Assert.notNull(error, "Provided error cannot be null!");
        this.error = StandardExceptionError.of(error, message);
    }

    public GenericException(@NotNull GenericCategorizedError error) {
        Assert.notNull(error, "Provided error cannot be null!");
        this.error = StandardExceptionError.of(error);
    }

    public GenericException(@NotNull GenericExceptionError error) {
        Assert.notNull(error, "Provided error cannot be null!");
        this.error = error;
    }

    @NotNull
    public GenericExceptionError getError() {
        return error;
    }
}
