package com.tng.oss.pfk.infrastructure.core.error;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public interface GenericError {
    int getCode();

    @NotBlank
    String getMessage();

    @JsonIgnore
    default boolean isSuccessful() {
        return 0 == getCode();
    }
}
