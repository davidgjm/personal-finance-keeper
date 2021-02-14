package com.tng.oss.pfk.infrastructure.core.validation;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class GenericAssertions {
    private GenericAssertions() {
        throw new AssertionError("constructor invalid call for utility class");
    }

    public static void notNull(Object object, String message) {
        if (null == object) {
            throw new GenericValidationException(ValidationError.COMMON_ARGUMENT_NULL, message);
        }
    }

    public static void notNull(Object object) {
        if (null == object) {
            throw new GenericValidationException(ValidationError.COMMON_ARGUMENT_NULL);
        }
    }

    /**
     *
     * @param number Number to be tested. <b>Null</b> value is considered invalid
     * @param message optional message
     */
    public static void notNegative(BigDecimal number, String message) {
        if (number == null || number.compareTo(BigDecimal.ZERO) < 0) {
            throw new GenericValidationException(ValidationError.COMMON_NUMBER_NEGATIVE, message);
        }
    }

    public static void isPast(LocalDate date, String message) {
        if (null == date || !date.isBefore(LocalDate.now())) {
            throw new GenericValidationException(ValidationError.COMMON_DATE_NOT_PAST, message);
        }
    }

    public static void isPast(LocalDate date) {
        if (null == date || !date.isBefore(LocalDate.now())) {
            throw new GenericValidationException(ValidationError.COMMON_DATE_NOT_PAST);
        }
    }
}
