package com.tng.oss.pfk.fundmanagement.infrastructure;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;

public enum FundManagementError implements GenericCategorizedError {
    COMPANY_NOT_FOUND(1, 1, "Fund Company not found"),
    COMPANY_NAME_ALREADY_EXISTS(1, 2, "Fund Company with the same name already exists"),
    COMPANY_NAME_MISMATCH(1, 3, "Company name mismatch"),

    MANAGER_NOT_FOUND(2,1,"Fund manager not found"),
    MANAGER_ID_EXISTS(2,2,"Fund manager ID provided. Potential existing entity!"),
    MANAGER_NAME_INCONSISTENT(2,3,"Fund manager name different from record"),
    ;
    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;

    FundManagementError(int category, int sequence, String message) {
        this.namespace = 2;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
    }

    FundManagementError(int sequence, String message) {
        this(0, sequence, message);
    }

    @Override
    public short getNamespace() {
        return this.namespace;
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
