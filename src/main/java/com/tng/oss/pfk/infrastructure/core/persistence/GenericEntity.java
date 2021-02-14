package com.tng.oss.pfk.infrastructure.core.persistence;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

public interface GenericEntity<ID extends Serializable> extends Persistable<ID> {
}
