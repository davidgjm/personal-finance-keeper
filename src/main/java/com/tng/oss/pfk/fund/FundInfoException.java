package com.tng.oss.pfk.fund;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;
import com.tng.oss.pfk.infrastructure.core.error.GenericException;

public final class FundInfoException extends GenericException {
    public FundInfoException(GenericCategorizedError error, String message) {
        super(error, message);
    }

    public FundInfoException(GenericCategorizedError error, String message, Throwable cause) {
        super(error, message, cause);
    }

    public FundInfoException(GenericCategorizedError error) {
        super(error);
    }
}
