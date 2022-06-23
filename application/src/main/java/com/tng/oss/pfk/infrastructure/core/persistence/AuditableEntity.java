package com.tng.oss.pfk.infrastructure.core.persistence;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity extends BaseEntity{
    @PastOrPresent
    @Getter
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant created;


    @PastOrPresent
    @Getter
    @Column(nullable = false)
    @LastModifiedDate
    private Instant lastUpdated;
}
