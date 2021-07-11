package com.tng.oss.pfk.fundmanagement.domain.model;

import com.tng.oss.pfk.domain.common.model.vo.FlexibleLargeVolume;
import com.tng.oss.pfk.infrastructure.core.persistence.AuditableEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_PRECISION;
import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_SCALE;

@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.PUBLIC)
public final class FundManager extends AuditableEntity {
    @EqualsAndHashCode.Include
    @NotBlank
    @Column(nullable = false, updatable = false, length = 10)
    private String name;

    @NotNull
    @Past
    @Column(nullable = false)
    private LocalDate careerStarted;

    @PositiveOrZero
    private Long companyId;

    private FlexibleLargeVolume totalManagedAsset;

    @NotNull
    @Column(nullable = false, precision = RETURN_RATE_PRECISION, scale = RETURN_RATE_SCALE)
    private BigDecimal annualReturnRate;

    @NotNull
    @Column(nullable = false, precision = RETURN_RATE_PRECISION, scale = RETURN_RATE_SCALE)
    private BigDecimal bestReturnRate;

    @Column(length = 1024)
    private String introduction;

    private String investingStyle;

}
