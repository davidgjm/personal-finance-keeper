package com.tng.oss.pfk.infrastructure.core.validation;

import com.tng.oss.pfk.infrastructure.core.error.GenericException;

import javax.validation.constraints.NotNull;

public class GenericValidationException extends GenericException {
    public GenericValidationException(@NotNull SystemCommonError error, String message) {
        super(error, message);
    }

    public GenericValidationException(@NotNull SystemCommonError error) {
        super(error);
    }
}
