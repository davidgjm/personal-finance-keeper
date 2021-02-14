package com.tng.oss.pfk.infrastructure.core.error;

import javax.validation.constraints.NotBlank;

public interface GenericError {
    int getCode();

    @NotBlank
    String getMessage();

    default boolean isSuccessful() {
        return 0 == getCode();
    }
}
