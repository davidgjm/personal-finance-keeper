package com.tng.oss.pfk.domain.stocks.model;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_stock_code", columnNames = {"code"})
        },
        indexes = {
                @Index(name = "idx_stock_code", columnList = "code")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor
public class Stock extends BaseEntity {
    @NotBlank
    @Pattern(regexp = "\\d{6}")
    @Column(nullable = false, updatable = false)
    private String code;

    @Size(max = 64)
    @Column(nullable = false, length = 64)
    private String name;

    private String industry;

    private String description;
}
