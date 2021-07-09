package com.tng.oss.pfk.infrastructure.core.error;

import org.springframework.util.Assert;

public final class GenericErrorUtil {
    private GenericErrorUtil() {
        throw new AssertionError("unexpected call to default constructor");
    }

    public static void validateInternalCode(int code) {
        Assert.isTrue(code >=0 && code < 256, "Invalid internal code!");
    }
}
