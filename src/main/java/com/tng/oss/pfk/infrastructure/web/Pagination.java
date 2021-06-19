package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


@Data
public final class Pagination {
    @JsonProperty(required = true)
    @NotNull
    @PositiveOrZero
    private final Long totalPages;

    @JsonProperty(required = true)
    @NotNull
    @PositiveOrZero
    private final Long totalElements;

    public static Pagination of(long totalPages, long totalElements) {
        GenericAssertions.isTrue(totalPages >=0, "totalPages cannot be negative value!");
        GenericAssertions.isTrue(totalElements >=0, "totalElements cannot be negative value!");
        return new Pagination(totalPages, totalElements);
    }
}
