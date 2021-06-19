package com.tng.oss.pfk.infrastructure.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class SystemCommonErrorTest {

    @Test
    void test_sequence_ok() {
        var error = SystemCommonError.OK;
        int code = error.getCode();
        log.info("Error code: {}", code);
        Assertions.assertEquals(0, code);
    }

    @Test
    void test_category_0() {
        var error = SystemCommonError.COMMON_ARGUMENT_NULL;
        int code = error.getCode();
        Assertions.assertEquals(0, error.getCategory());
        Assertions.assertNotEquals(0, error.getSequence());
        log.info("Error code: {}, binary: {}", code, Integer.toBinaryString(code));
        Assertions.assertNotEquals(0, code);
    }
    @Test
    void test_sequence_normal() {
        var error = SystemCommonError.COMMON_STRING_NO_TEXT;
        int code = error.getCode();
        Assertions.assertNotEquals(0, error.getCategory());
        Assertions.assertNotEquals(0, error.getSequence());
        log.info("Error code: {}, binary: {}", code, Integer.toBinaryString(code));
        Assertions.assertNotEquals(0, code);
    }
}