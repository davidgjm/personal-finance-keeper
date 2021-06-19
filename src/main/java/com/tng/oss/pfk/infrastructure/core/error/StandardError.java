package com.tng.oss.pfk.infrastructure.core.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public final class StandardError implements GenericError {
    @JsonProperty(required = true)
    private final int code;

    @JsonProperty(required = true)
    private final String message;

    public static StandardError of(@NotNull @Valid GenericError error) {
        return new StandardError(error.getCode(), error.getMessage());
    }
}
