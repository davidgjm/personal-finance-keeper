package com.tng.oss.pfk.infrastructure.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "server.exception-handling")
public class ExceptionHandlingConfig {
    private Integer defaultCustomExceptionStatus;
    private boolean includeHttpStatus;
    private Map<String, Integer> httpStatusMapping;
}
