package com.tng.oss.pfk.infrastructure.web;

import com.tng.oss.pfk.infrastructure.core.error.GenericError;

import javax.validation.constraints.NotNull;

public interface GenericErrorResponse {
    @NotNull
    GenericError getError();
}
