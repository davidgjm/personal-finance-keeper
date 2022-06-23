package com.tng.oss.pfk.infrastructure.web;

import com.tng.oss.pfk.infrastructure.core.error.GenericException;

public class WebApiException extends GenericException {
    public WebApiException(GeneralWebError error, String message) {
        super(error, message);
    }

    public WebApiException(GeneralWebError error) {
        super(error);
    }
}
