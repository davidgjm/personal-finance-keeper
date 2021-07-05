package com.tng.oss.pfk.infrastructure.core.validation;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public final class GenericAssertions {
    private GenericAssertions() {
        throw new AssertionError("constructor invalid call for utility class");
    }

    public static void notNull(Object object, String message) {
        if (null == object) {
            throw new GenericValidationException(SystemCommonError.COMMON_ARGUMENT_NULL, message);
        }
    }

    public static void notNull(Object object) {
        if (null == object) {
            throw new GenericValidationException(SystemCommonError.COMMON_ARGUMENT_NULL);
        }
    }

    public static void isTrue(boolean condition, String message) {
        if (!condition) {
            throw new GenericValidationException(SystemCommonError.COMMON_CONDITION_NOT_MET, message);
        }
    }

    public static void hasText(@NotBlank String comment, String input) {
        if (!StringUtils.hasText(input)) {
            throw new GenericValidationException(SystemCommonError.COMMON_STRING_NO_TEXT);
        }
    }

    /**
     *
     * @param number Number to be tested. <b>Null</b> value is considered invalid
     * @param message optional message
     */
    public static void notNegative(BigDecimal number, String message) {
        if (number == null || number.compareTo(BigDecimal.ZERO) < 0) {
            throw new GenericValidationException(SystemCommonError.COMMON_NUMBER_NEGATIVE, message);
        }
    }

    public static void isPositive(Long number, String message) {
        if (number == null || number <= 0) {
            throw new GenericValidationException(SystemCommonError.COMMON_NUMBER_NOT_POSITIVE, message);
        }
    }



    public static void notFuture(Instant instant, String message) {
        if (null == instant || instant.compareTo(Instant.now()) >0 ) {
            throw new GenericValidationException(SystemCommonError.COMMON_DATE_NOT_PAST, message);
        }
    }

    public static void isPast(LocalDate date, String message) {
        if (null == date || !date.isBefore(LocalDate.now())) {
            throw new GenericValidationException(SystemCommonError.COMMON_DATE_NOT_PAST, message);
        }
    }

    public static void isPast(Instant instant) {
        if (null == instant || !instant.isBefore(Instant.now())) {
            throw new GenericValidationException(SystemCommonError.COMMON_DATE_NOT_PAST);
        }
    }
}
