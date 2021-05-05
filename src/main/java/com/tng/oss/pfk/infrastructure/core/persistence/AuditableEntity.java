package com.tng.oss.pfk.infrastructure.core.persistence;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditableEntity extends BaseEntity{
    @PastOrPresent
    @Getter
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @PastOrPresent
    @Getter
    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @PrePersist
    private void onCreate() {
        if (created == null) {
            created = LocalDateTime.now();
        }
        lastUpdated = created;
        extraCreateHook();
    }

    @PreUpdate
    private void onUpdate() {
        lastUpdated = LocalDateTime.now();
        extraUpdateHook();
    }

    protected void extraCreateHook() {}

    protected void extraUpdateHook() {}
}
