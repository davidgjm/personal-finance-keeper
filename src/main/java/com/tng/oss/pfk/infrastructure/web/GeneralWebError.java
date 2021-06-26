package com.tng.oss.pfk.infrastructure.web;

import com.tng.oss.pfk.infrastructure.core.error.GenericCategorizedError;

public enum GeneralWebError implements GenericCategorizedError {
    ID_MISSING(1, "resource ID missing in request payload"),
    ID_MISMATCH_IN_PATH_PAYLOAD(2, "Resource ID mismatch in path variable and payload")
    ;
    private final short namespace;
    private final short category;
    private final short sequence;
    private final String message;

    GeneralWebError(int category, int sequence, String message) {
        this.namespace = 100;
        this.category = (short) category;
        this.sequence = (short) sequence;
        this.message = message;
    }

    GeneralWebError(int sequence, String message) {
        this(0, sequence, message);
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
