package com.tng.oss.pfk.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.infrastructure.core.error.StandardError;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import com.tng.oss.pfk.infrastructure.core.validation.SystemCommonError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public final class PaginatedResponsePayload<E> implements GenericResponse<List<E>> {

    @JsonProperty(required = true)
    private final StandardError error;

    private final Pagination pagination;

    private List<E> data;


    public static <D> PaginatedResponsePayload<D> ok(Page<D> page) {
        GenericAssertions.notNull(page, "Page cannot be null!");
        GenericAssertions.notNull(page.getContent(), "Page content cannot be null!");
        var data = page.getContent();
        if (data.isEmpty()) {
            return EMPTY;
        }
        return new PaginatedResponsePayload<>(
                StandardError.of(SystemCommonError.OK),
                Pagination.of(page.getTotalPages(), page.getTotalElements()),
                data
        );
    }

    public static PaginatedResponsePayload EMPTY = new PaginatedResponsePayload(StandardError.of(SystemCommonError.OK), null, Collections.emptyList());
}
