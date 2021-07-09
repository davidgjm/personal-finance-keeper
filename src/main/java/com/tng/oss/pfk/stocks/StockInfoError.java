package com.tng.oss.pfk.stocks;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;
import com.tng.oss.pfk.infrastructure.core.error.GenericErrorUtil;

public enum StockInfoError implements GenericCategorizedError {
    INDUSTRY_CODE_NAME_CONFLICTS(0, 0, "Industry code/name conflicts with another"),
    INDUSTRY_SELF_AS_PARENT(0, 1, "Industry cannot be its own parent!"),
    INDUSTRY_CODE_ALREADY_EXISTS(0, 2, "Industry code already exists!"),
    INDUSTRY_NOT_FOUND(0, 2, "Industry does not exist!"),


    STOCK_NOT_FOUND(1,0, "Stock code not found!")
    ;
    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;

    StockInfoError(int category, int sequence, String message) {
        GenericErrorUtil.validateInternalCode(category);
        GenericErrorUtil.validateInternalCode(sequence);
        this.namespace = 3;
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
