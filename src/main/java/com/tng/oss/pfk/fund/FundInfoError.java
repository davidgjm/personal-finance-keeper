package com.tng.oss.pfk.fund;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;
import com.tng.oss.pfk.infrastructure.core.error.GenericErrorUtil;

public enum FundInfoError implements GenericCategorizedError {
    FUND_ALREADY_EXISTS(1, 0, "Fund already exists!"),
    FUND_NOT_FOUND(1, 1, "Fund not found!"),
    ;
    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;

    FundInfoError(int category, int sequence, String message) {
        GenericErrorUtil.validateInternalCode(category);
        GenericErrorUtil.validateInternalCode(sequence);
        this.namespace = 4;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
    }

    @Override
    public short getNamespace() {
        return namespace;
    }

    @Override
    public short getCategory() {
        return category;
    }

    @Override
    public short getSequence() {
        return sequence;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
