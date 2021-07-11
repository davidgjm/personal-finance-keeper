package com.tng.oss.pfk.domain.common.model.vo;

import com.tng.oss.pfk.infrastructure.core.validation.GenericValidationException;
import com.tng.oss.pfk.infrastructure.core.validation.SystemCommonError;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FlexibleLargeVolumeTest {

    @Test
    void test_null() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new FlexibleLargeVolume(null, null);
        });
        assertEquals(SystemCommonError.COMMON_ARGUMENT_NULL.getCode(), exception.getError().getCode());
    }

    @Test
    void test_negative() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new FlexibleLargeVolume(BigDecimal.valueOf(-10), null);
        });
        assertEquals(SystemCommonError.COMMON_NUMBER_NEGATIVE.getCode(), exception.getError().getCode());
    }

    @Test
    void test_null_volume() {
        var exception = assertThrows(GenericValidationException.class, () ->{
            new FlexibleLargeVolume(BigDecimal.valueOf(10), null);
        });
        assertEquals(SystemCommonError.COMMON_ARGUMENT_NULL.getCode(), exception.getError().getCode());
    }


    @Test
    void test_billion() {
        var volume = FlexibleLargeVolume.ofBillion(BigDecimal.valueOf(1234.123456));
        var amount = volume.getVolume();
        System.out.printf("Volume scale=%d, precision=%d%n", amount.scale(), amount.precision());
        assertTrue(amount.scale() <=6);
        assertTrue(amount.precision() <= 10);
    }

    @Test
    void test_value_copy() {
        var volume = FlexibleLargeVolume.ofBillion(BigDecimal.valueOf(1234.123456));
        var amount = volume.getVolume();
        var updated = amount.add(BigDecimal.ONE);
        assertNotSame(amount, updated);
    }
}