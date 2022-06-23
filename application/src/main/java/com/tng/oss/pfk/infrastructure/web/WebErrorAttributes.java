package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tng.oss.pfk.infrastructure.core.error.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebErrorAttributes extends DefaultErrorAttributes {
    private static final ConcurrentHashMap<String, HttpStatus> MAPPING = new ConcurrentHashMap<>(8);
    private final ExceptionHandlingConfig exceptionHandlingConfig;
    private final ObjectMapper objectMapper;

    public WebErrorAttributes(ExceptionHandlingConfig exceptionHandlingConfig, Jackson2ObjectMapperBuilder objectMapperBuilder) {
        Assert.notNull(exceptionHandlingConfig, "Exception handling config cannot be null!");
        Assert.notEmpty(exceptionHandlingConfig.getHttpStatusMapping(), "Exception Http status mapping cannot be empty!");
        this.exceptionHandlingConfig = exceptionHandlingConfig;
        this.objectMapper = objectMapperBuilder.createXmlMapper(false).build();
    }

    @PostConstruct
    private void load() {
        this.exceptionHandlingConfig.getHttpStatusMapping().forEach((ex, status) -> {
            HttpStatus s = null;
            try {
                s = HttpStatus.valueOf(status);
            } catch (IllegalArgumentException e) {
                log.error("Unexpected status specified! Unable to resolve the mapping. status={}, exception={}", status, ex);
            }
            if (s != null) {
                MAPPING.put(ex, s);
            }
        });
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        WebError result = new WebError();
        result.setTimestamp(Instant.now());

        Throwable error = getError(webRequest);
        HttpStatus status = resolveHttpStatus(webRequest, error);
        setCode(result, status, error);
        setError(result, webRequest, error);
        setErrorDetails(result, error);

        var values = objectMapper.convertValue(result, new TypeReference<HashMap<String, Object>>() {});

        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        errorAttributes.put("error", values);
        if (status != null) {
            errorAttributes.put("httpStatus", status.value());
        }
        return errorAttributes;
    }


    private void setError(WebError<? extends Serializable> webError, WebRequest webRequest, Throwable error) {
        if (error instanceof GenericException) {
            GenericException ge = (GenericException) error;
            var applicationError = ge.getError();
            webError.setType(WebError.ErrorType.APPLICATION);
            webError.setMessage(applicationError.getMessage());
            webError.setExplanation(applicationError.getDetailedMessage());
        } else {
            webError.setType(WebError.ErrorType.SYSTEM);
            webError.setMessage(getMessage(webRequest, error));
        }

    }

    private void setCode(WebError<? extends Serializable> webError, HttpStatus httpStatus, Throwable error) {
        if (error instanceof GenericException) {
            GenericException ge = (GenericException) error;
            var applicationError = ge.getError();
            webError.setCode(applicationError.getCode());
        } else {
            webError.setCode(Objects.requireNonNullElse(httpStatus.value(), WebError.UNKNOWN_ERROR_CODE));
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void setErrorDetails(WebError webError, Throwable error) {
        BindingResult result = extractBindingResult(error);
        if (result != null) {
            webError.setDetails(result.getAllErrors());
        }
    }

    private HttpStatus resolveHttpStatus(WebRequest webRequest, Throwable error) {
        if (error instanceof ResponseStatusException) {
            var ex = (ResponseStatusException) error;
            return ex.getStatus();
        }
        var status = MAPPING.get(error.getClass().getName());
        log.debug("Http status from mapping. status={}, error={}", status, error.getClass().getName());
        if (status != null) {
            return status;
        }
        MergedAnnotation<ResponseStatus> responseStatusAnnotation = MergedAnnotations
                .from(error.getClass(), MergedAnnotations.SearchStrategy.TYPE_HIERARCHY).get(ResponseStatus.class);
        if (responseStatusAnnotation.isPresent()) {
            var result = responseStatusAnnotation.getValue("code", HttpStatus.class);
            if (result.isPresent()) {
                return result.get();
            }
        }

        Integer statusCode = getAttribute(webRequest, RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode != null && statusCode != 500) {
            return HttpStatus.valueOf(statusCode);
        }

        if (error instanceof GenericException) {
            return HttpStatus.OK;
        }
        log.info("Failed to resolve HttpStatus. Exception type:{} ", error.getClass().getName());
        return null;
    }


    private BindingResult extractBindingResult(Throwable error) {
        if (error instanceof BindingResult) {
            return (BindingResult) error;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
        return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }

}
