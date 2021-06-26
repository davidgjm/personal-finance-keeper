package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tng.oss.pfk.infrastructure.core.error.StandardError;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class WebError<T extends Serializable> extends StandardError {
    @JsonSerialize(using = HttpStatusSerializer.class)
    private HttpStatus httpStatus;
    private ErrorType type;
    private Instant timestamp;
    private String explanation;
    private List<T> details;


    public static enum ErrorType {
        APPLICATION,
        SYSTEM
    }

    public static final int UNKNOWN_ERROR_CODE = 999;
}
