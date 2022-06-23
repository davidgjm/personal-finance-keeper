package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.infrastructure.core.error.StandardError;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import com.tng.oss.pfk.infrastructure.core.validation.SystemCommonError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public final class ListResponsePayload<E> implements GenericResponse<List<E>> {

    @JsonProperty(required = true)
    private final StandardError error;

    private List<E> data;


    public static <D> ListResponsePayload<D> ok(List<D> items) {
        GenericAssertions.notNull(items, "Page cannot be null!");
        if (items.isEmpty()) {
            return EMPTY;
        }
        return new ListResponsePayload<>(
                StandardError.of(SystemCommonError.OK),
                items
        );
    }

    public static ListResponsePayload EMPTY = new ListResponsePayload(StandardError.of(SystemCommonError.OK), Collections.emptyList());
}
