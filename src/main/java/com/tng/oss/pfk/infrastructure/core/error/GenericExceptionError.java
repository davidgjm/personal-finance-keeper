package com.tng.oss.pfk.infrastructure.core.error;

public interface GenericExceptionError extends GenericCategorizedError {
    String getDetailedMessage();
}
