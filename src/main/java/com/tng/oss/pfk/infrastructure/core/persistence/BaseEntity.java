package com.tng.oss.pfk.infrastructure.core.persistence;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BaseEntity implements GenericEntity<Long> {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Nullable
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    public BaseEntity() {
    }

    @Transient
    @Override
    public boolean isNew() {
        return null == this.getId();
    }
}
