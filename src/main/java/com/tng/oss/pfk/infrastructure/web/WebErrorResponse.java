package com.tng.oss.pfk.infrastructure.web;

import com.tng.oss.pfk.infrastructure.core.error.GenericException;
import com.tng.oss.pfk.infrastructure.core.validation.SystemCommonError;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.RequestDispatcher;
import java.io.Serializable;
import java.time.Instant;

@RequiredArgsConstructor
@Data
public final class WebErrorResponse<T extends Serializable> implements GenericErrorResponse{
    private final WebError<T> error;


    public static <T extends Serializable> WebErrorResponse<T> of(Throwable ex, WebRequest request) {
        WebError<T> output = new WebError<>();
        output.setTimestamp(Instant.now());
        if (ex instanceof GenericException) {
            GenericException ge = (GenericException) ex;
            output.setType(WebError.ErrorType.APPLICATION);
            output.setCode(ge.getError().getCode());
            output.setMessage(ge.getError().getMessage());
            output.setExplanation(ge.getError().getDetailedMessage());
        } else {
            output.setType(WebError.ErrorType.SYSTEM);
            output.setCode(SystemCommonError.UNKNOWN_OR_SYSTEM_ERROR.getCode());
            output.setMessage(ex.getMessage());
        }
        HttpStatus status = getStatus(request);
        output.setHttpStatus(status);
        return new WebErrorResponse<>(output);
    }

    private static HttpStatus getStatus(WebRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE, RequestAttributes.SCOPE_REQUEST);
        if (statusCode != null) {
            return HttpStatus.valueOf(statusCode);
        }
        return null;
    }
}
