package com.tng.oss.pfk.stocks;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;
import com.tng.oss.pfk.infrastructure.core.error.GenericException;

public class StockInfoException extends GenericException {
    public StockInfoException(GenericCategorizedError error, String message) {
        super(error, message);
    }

    public StockInfoException(GenericCategorizedError error) {
        super(error);
    }
}
