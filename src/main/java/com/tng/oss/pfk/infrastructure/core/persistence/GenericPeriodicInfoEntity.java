package com.tng.oss.pfk.infrastructure.core.persistence;

import java.time.LocalDate;


public interface GenericPeriodicInfoEntity extends GenericEntity<Long> {
    LocalDate getRecordDate();
}
