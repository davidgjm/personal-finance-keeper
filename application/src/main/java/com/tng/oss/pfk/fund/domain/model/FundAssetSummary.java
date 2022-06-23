package com.tng.oss.pfk.fund.domain.model;

import com.tng.oss.pfk.domain.common.model.vo.FlexibleLargeVolume;
import com.tng.oss.pfk.infrastructure.core.persistence.AuditableEntity;
import com.tng.oss.pfk.infrastructure.core.persistence.GenericPeriodicInfoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_asset_sum_code_date", columnNames = {"code", "recordDate"})
        },
        indexes = {
                @Index(name = "idx_asset_summary_code", columnList = "code")
        }
)
public final class FundAssetSummary extends AuditableEntity implements GenericPeriodicInfoEntity {

    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "Invalid fund code")
    @EqualsAndHashCode.Include
    private String code;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private LocalDate recordDate;


    @NotNull
    @Embedded
    private FlexibleLargeVolume assetVolume;


    @PositiveOrZero
    @Column(precision = 5, scale = 2)
    private BigDecimal equityPercentage;

    @PositiveOrZero
    @Column(precision = 5, scale = 2)
    private BigDecimal bondPercentage;

    @PositiveOrZero
    @Column(precision = 5, scale = 2)
    private BigDecimal cashPercentage;

}
