package com.tng.oss.pfk.sandbox;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class BitwiseOperations {

    @Test
    void bit_shift_left_byte_positive() {
        byte val=25;
        System.out.printf("Binary value for %s:%s\n", val, Integer.toBinaryString(val));
    }
    @Test
    void bit_shift_left_short_positive() {
        short val=2555;
        System.out.printf("Binary value for %s:%s\n", val, Integer.toBinaryString(val));
    }

    @Test
    void bit_shift_left_byte_negative() {
        byte val=-25;
        System.out.printf("Binary value for %s:%s\n", val, Byte.parseByte("25"));
        System.out.printf("Negative Binary value for %s:%s\n", val, Integer.toBinaryString(val & 0xff));
    }
    @Test
    void bit_byte() {
        byte positive = 127;
        System.out.printf("Positive binary: value=%s, raw=%s, cleansed=%s%n",  positive, Integer.toBinaryString(positive ), Integer.toBinaryString(positive & 0xff));
        byte val = -127;
        System.out.printf("Negative binary: value=%s, raw=%s, cleansed=%s%n",  val, Integer.toBinaryString(val ), Integer.toBinaryString(val & 0xff));

        System.out.printf("Unsigned negative: %s%n", Byte.toUnsignedInt(val));
    }

    @Test
    void byte_concat_1() {
        var result = concatBytes(1, 1, 1);
        Assertions.assertNotEquals(0, result);
    }

    @Test
    void byte_concat_127() {
        var result = concatBytes(127, 127, 127);
        Assertions.assertNotEquals(0, result);
    }

    @Test
    void short_concat_254() {
        short n=254,c=254,s=254;
        var result = n << 16 | c << 8 | s;
        log.info("Bit or |: {}, binary={}", result, Integer.toBinaryString(result));
    }
    @Test
    void short_concat_255() {
        short n=255,c=255,s=255;
        var result = n << 16 | c << 8 | s;
        log.info("Bit or |: {}, binary={}", result, Integer.toBinaryString(result));
    }

    @Test
    void short_mod_0() {
        short val = 256;
        var result = val % 256;
        log.info("input={}, remainder={}", val, result);
    }

    @Test
    void short_mod_non_zero() {
        short val = 256+9;
        var result = val % 256;
        log.info("input={}, remainder={}", val, result);
    }

    @Test
    void short_mod_smaller() {
        short val = 254;
        var result = val % 256;
        log.info("input={}, remainder={}", val, result);
    }

    @Test
    void short_mod_negative() {
        short val = -1254;
        var result = val % 256;
        log.info("input={}, remainder={}", val, result);
    }

    @Test
    void bitwise_restore() {
        int val = 65794;
        log.info("Original binary stream: {}", Integer.toBinaryString(val));
        log.info("left 8: {}", Integer.toBinaryString(val >>> 16 & 0xff));
        log.info("center 8: {}", Integer.toBinaryString(val >>> 8 & 0xff));
        log.info("last 8: {}", Integer.toBinaryString(val & 0xff));
    }

    private int concatBytes(int n, int c, int s) {
        var result = (byte)n << 16 | (byte)c << 8 | (byte)s;
        log.info("Bit or |: {}, binary={}", result, Integer.toBinaryString(result));
        return result;
    }
}
