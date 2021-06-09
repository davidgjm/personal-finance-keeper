package com.tng.oss.pfk.domain.fund.model;

import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@Setter(AccessLevel.PRIVATE)
public class FundHoldingItem {

    @NotNull
    @Positive
    private Long stockId;

    @NotNull
    @PositiveOrZero
    private BigDecimal netAssetValueRatio;

    @NotNull
    @Past
    private LocalDate reportDate;

    public void setReportDate(@NotNull @Past LocalDate reportDate) {
        GenericAssertions.isPast(reportDate, "Report date cannot be present or future!");
        this.reportDate = reportDate;
    }
}
