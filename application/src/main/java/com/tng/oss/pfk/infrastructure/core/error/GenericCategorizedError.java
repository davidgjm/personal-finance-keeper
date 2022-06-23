package com.tng.oss.pfk.infrastructure.core.error;

import javax.validation.constraints.PositiveOrZero;

public interface GenericCategorizedError extends GenericError {
    @PositiveOrZero
    short getNamespace();

    @PositiveOrZero
    short getCategory();

    @PositiveOrZero
    short getSequence();

    @Override
    default int getCode() {
        var _n = Math.abs(getNamespace()) % 256;
        var _c = Math.abs(getCategory()) % 256;
        var _s = Math.abs(getSequence()) % 256;
        return _n << 16 | _c << 8 | _s;
    }
}
