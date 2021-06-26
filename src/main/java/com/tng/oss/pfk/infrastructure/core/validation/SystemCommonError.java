package com.tng.oss.pfk.infrastructure.core.validation;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;

import javax.validation.constraints.PositiveOrZero;

public enum SystemCommonError implements GenericCategorizedError {
    OK(0, "OK"),
    COMMON_ARGUMENT_NULL(1, "Argument or parameter cannot be null!"),
    COMMON_NUMBER_NEGATIVE(1, "Number cannot be negative!"),
    COMMON_NUMBER_NOT_POSITIVE(2, "Number cannot be zero or negative!"),
    COMMON_DATE_NOT_PAST(3, "Date cannot be past or present!"),
    COMMON_CONDITION_NOT_MET(4, "Unexpected condition!"),

    /**
     * STRING VALIDATION ERRORS falls into 11xx namespace
     */
    COMMON_STRING_NO_TEXT(1, 2, "String cannot be null/empty!"),

    UNKNOWN_OR_SYSTEM_ERROR(255,255,255, "Unknown or system error")
    ;

    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;

    SystemCommonError(int namespace, int category, int sequence, String message) {
        this.namespace = (short) namespace;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
    }

    SystemCommonError(int category, int sequence, String message) {
        this(0, category, sequence, message);
    }


    SystemCommonError(int sequence, String message) {
        this(0, sequence, message);
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public @PositiveOrZero short getNamespace() {
        return (short) Math.abs(namespace);
    }

    @Override
    public @PositiveOrZero short getCategory() {
        return (short) Math.abs(category);
    }

    @Override
    public @PositiveOrZero short getSequence() {
        return (short) Math.abs(sequence);
    }
}
