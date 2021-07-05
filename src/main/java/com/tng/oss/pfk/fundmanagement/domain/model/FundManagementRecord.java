package com.tng.oss.pfk.fundmanagement.domain.model;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_PRECISION;
import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_SCALE;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_fund_manager", columnNames = {"fundId", "ManagerId"})
        },
        indexes = {@Index(name = "idx_return_rate", columnList = "returnRate")}
)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class FundManagementRecord extends BaseEntity {
    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long fundId;

    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long ManagerId;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    private LocalDate start;

    @PastOrPresent
    private LocalDate finish;

    @Transient
    public Period getPeriod() {
        return start.until(Objects.requireNonNullElseGet(finish, LocalDate::now));
    }

    @NotNull
    @Positive
    @Column(nullable = false, precision = RETURN_RATE_PRECISION, scale = RETURN_RATE_SCALE)
    private BigDecimal returnRate;

}
