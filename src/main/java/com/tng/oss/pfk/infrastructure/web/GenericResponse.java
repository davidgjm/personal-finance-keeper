package com.tng.oss.pfk.infrastructure.web;

public interface GenericResponse<T> extends GenericErrorResponse{
    T getData();
}
