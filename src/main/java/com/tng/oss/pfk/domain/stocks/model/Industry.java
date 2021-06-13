package com.tng.oss.pfk.domain.stocks.model;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_code", columnNames = {"code"})
        }
)
public class Industry extends BaseEntity {

    @NotBlank
    @Size(min = 4, max = 4)
    @Column(nullable = false, updatable = false, length = 4)
    private String code;

    @NotBlank
    @Column(nullable = false, updatable = false, length = 128)
    private String name;
}
