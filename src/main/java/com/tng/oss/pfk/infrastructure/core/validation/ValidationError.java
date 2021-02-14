package com.tng.oss.pfk.infrastructure.core.validation;

import com.tng.oss.pfk.infrastructure.core.error.GenericError;

public enum ValidationError implements GenericError {
    COMMON_ARGUMENT_NULL(1000, "Argument or parameter cannot be null!"),
    COMMON_NUMBER_NEGATIVE(1001, "Number cannot be negative!"),
    COMMON_DATE_NOT_PAST(1002, "Date cannot be past or present!"),
    MONEY_AMOUNT_INVALID(1100, "Invalid money amount")
    ;

    private final int code;
    private final String message;

    ValidationError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
