package com.tng.oss.pfk.domain.common.model.vo;

import com.tng.oss.pfk.infrastructure.core.validation.GenericValidationException;
import com.tng.oss.pfk.infrastructure.core.validation.ValidationError;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SecurityVolumeTest {

    @Test
    void test_null() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new SecurityVolume(null, null);
        });
        assertEquals(ValidationError.COMMON_ARGUMENT_NULL.getCode(), exception.getError().getCode());
    }

    @Test
    void test_negative() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new SecurityVolume(BigDecimal.valueOf(-10), null);
        });
        assertEquals(ValidationError.COMMON_NUMBER_NEGATIVE.getCode(), exception.getError().getCode());
    }

    @Test
    void test_null_volume() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new SecurityVolume(BigDecimal.valueOf(10), null);
        });
        assertEquals(ValidationError.COMMON_ARGUMENT_NULL.getCode(), exception.getError().getCode());
    }


    @Test
    void test_billion() {
        var volume = SecurityVolume.ofBillion(BigDecimal.valueOf(1234.123456));
        var amount = volume.amount();
        System.out.printf("Volume scale=%d, precision=%d%n", amount.scale(), amount.precision());
        assertTrue(amount.scale() <=6);
        assertTrue(amount.precision() <= 10);
    }

    @Test
    void test_value_copy() {
        var volume = SecurityVolume.ofBillion(BigDecimal.valueOf(1234.123456));
        var amount = volume.amount();
        var updated = amount.add(BigDecimal.ONE);
        assertNotSame(amount, updated);
    }
}