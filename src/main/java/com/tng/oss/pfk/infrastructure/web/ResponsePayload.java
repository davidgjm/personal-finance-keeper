package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tng.oss.pfk.infrastructure.core.error.GenericError;
import com.tng.oss.pfk.infrastructure.core.error.StandardError;
import com.tng.oss.pfk.infrastructure.core.validation.SystemCommonError;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter(AccessLevel.NONE)
@Data
public class ResponsePayload<T> implements GenericResponse<T> {
    private final StandardError error;
    private T data;

    public ResponsePayload(StandardError error, T data) {
        this.error = error;
        this.data = data;
    }

    public static <T> ResponsePayload<T> of(@NotNull GenericError error, T data) {
        return new ResponsePayload<>(StandardError.of(error), data);
    }

    public static <T> ResponsePayload<T> ok(@NotNull T data) {
        return new ResponsePayload<>(StandardError.of(SystemCommonError.OK), data);
    }


    public static <T> ResponsePayload<T> error(@NotNull GenericError error) {
        return new ResponsePayload<>(StandardError.of(error), null);
    }
}
