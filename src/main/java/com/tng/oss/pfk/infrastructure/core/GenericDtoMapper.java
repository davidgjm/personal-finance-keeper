package com.tng.oss.pfk.infrastructure.core;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;

public interface GenericDtoMapper<S extends BaseEntity, T> {
    S asModel(T dto);

    T asDto(S model);
}
