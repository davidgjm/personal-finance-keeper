package com.tng.oss.pfk.infrastructure.core.error;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public final class StandardError implements GenericError {
    private final int code;
    private final String message;

    public static StandardError of(@NotNull @Valid GenericError error) {
        return new StandardError(error.getCode(), error.getMessage());
    }
}
