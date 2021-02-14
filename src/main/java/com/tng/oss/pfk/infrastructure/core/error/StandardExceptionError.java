package com.tng.oss.pfk.infrastructure.core.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public final class StandardExceptionError implements GenericExceptionError {
    private final int code;
    private final String message;
    private String detailedMessage;

    public GenericError genericError() {
        return new StandardError(this.code, this.message);
    }

    public static GenericExceptionError of(@NotNull GenericError genericError) {
        return new StandardExceptionError(genericError.getCode(), genericError.getMessage());
    }
    public static GenericExceptionError of(@NotNull GenericError genericError, String detailedMessage) {
        return new StandardExceptionError(genericError.getCode(), genericError.getMessage(), detailedMessage);
    }
}
