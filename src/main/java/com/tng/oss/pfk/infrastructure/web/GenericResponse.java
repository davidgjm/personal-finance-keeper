package com.tng.oss.pfk.infrastructure.web;

import com.tng.oss.pfk.infrastructure.core.error.StandardError;

import javax.validation.constraints.NotNull;

public interface GenericResponse<T> {
    @NotNull
    StandardError getError();

    T getData();
}
