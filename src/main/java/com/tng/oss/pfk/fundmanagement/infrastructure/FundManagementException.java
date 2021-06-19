package com.tng.oss.pfk.fundmanagement.infrastructure;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;
import com.tng.oss.pfk.infrastructure.core.error.GenericException;

public class FundManagementException extends GenericException {
    public FundManagementException(GenericCategorizedError error, String message) {
        super(error, message);
    }

    public FundManagementException(GenericCategorizedError error) {
        super(error);
    }
}
