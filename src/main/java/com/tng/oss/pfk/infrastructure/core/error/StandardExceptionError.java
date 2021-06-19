package com.tng.oss.pfk.infrastructure.core.error;

import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Setter(AccessLevel.NONE)
public final class StandardExceptionError implements GenericExceptionError {
    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;
    private String detailedMessage;

    public StandardExceptionError(int namespace, int category, int sequence, String message, String detailedMessage) {
        this.namespace = (short) namespace;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
        this.detailedMessage = detailedMessage;
    }
    public StandardExceptionError(int namespace, int category, int sequence, String message) {
        this.namespace = (short) namespace;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
    }

    public GenericError genericError() {
        return new StandardError(getCode(), this.message);
    }

    public static GenericExceptionError of(@NotNull GenericCategorizedError error) {
        GenericAssertions.notNull(error, "The provided GenericCategorizedError cannot be null!");
        return new StandardExceptionError(error.getNamespace(), error.getCategory(), error.getSequence(), error.getMessage());
    }

    public static GenericExceptionError of(@NotNull GenericCategorizedError error, String detailedMessage) {
        GenericAssertions.notNull(error, "The provided GenericCategorizedError cannot be null!");
        return new StandardExceptionError(error.getNamespace(), error.getCategory(), error.getSequence(), error.getMessage(), detailedMessage);
    }
}
