package com.tng.oss.pfk.infrastructure.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
public class WebErrorController extends BasicErrorController {
    private final ExceptionHandlingConfig exceptionHandlingConfig;
    public WebErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, ExceptionHandlingConfig exceptionHandlingConfig) {
        super(errorAttributes, serverProperties.getError());
        this.exceptionHandlingConfig = exceptionHandlingConfig;
    }

    @Override
    @RequestMapping/*(produces = MediaType.APPLICATION_JSON_VALUE)*/
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }
        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.APPLICATION_JSON));
        Integer customStatus = (Integer) body.get("httpStatus");
        if (customStatus != null) {
            log.info("Using custom http status from error attributes. Controller status={}, Custom status={}", status, customStatus);
            status = HttpStatus.valueOf(customStatus);
        }
        if (!exceptionHandlingConfig.isIncludeHttpStatus()) {
            body.remove("httpStatus");
        }

        return new ResponseEntity<>(body, status);
    }

    @Override
    protected HttpStatus getStatus(HttpServletRequest request) {
        return super.getStatus(request);
    }
}
