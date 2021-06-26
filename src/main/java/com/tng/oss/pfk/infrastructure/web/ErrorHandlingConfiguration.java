package com.tng.oss.pfk.infrastructure.web;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorHandlingConfiguration {



    @Bean
    public BasicErrorController customErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, ExceptionHandlingConfig exceptionHandlingConfig) {
        return new WebErrorController(errorAttributes, serverProperties, exceptionHandlingConfig);
    }
}
