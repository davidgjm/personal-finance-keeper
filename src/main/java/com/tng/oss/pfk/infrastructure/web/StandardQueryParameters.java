package com.tng.oss.pfk.infrastructure.web;

public final class StandardQueryParameters {
    private StandardQueryParameters() {
        throw new AssertionError("default constructor not expected ");
    }

    public static final String PAGINATION_PARAM_NUMBER = "pageNumber";
    public static final String PAGINATION_PARAM_SIZE = "pageSize";
    public static final int PAGINATION_DEFAULT_SIZE = 20;
    public static final int PAGINATION_FIRST_PAGE = 0;

}
