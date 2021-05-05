package com.tng.oss.pfk.domain.fund.model.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

import static com.tng.oss.pfk.infrastructure.RateConstants.FEE_RATE_PRECISION;
import static com.tng.oss.pfk.infrastructure.RateConstants.FEE_RATE_SCALE;

@Data
@Embeddable
public final class FundPurchaseInfo {

    @NotNull
    @Positive
    @Column(nullable = false, precision = FEE_RATE_PRECISION, scale = FEE_RATE_SCALE)
    private BigDecimal annualManagementFee;

    @NotNull
    @Positive
    @Column(nullable = false, precision = FEE_RATE_PRECISION, scale = FEE_RATE_SCALE)
    private BigDecimal custodianFee;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false, precision = FEE_RATE_PRECISION, scale = FEE_RATE_SCALE)
    private BigDecimal salesServiceFee;


    @NotNull
    @PositiveOrZero
    @Column(nullable = false, precision = FEE_RATE_PRECISION, scale = FEE_RATE_SCALE)
    private BigDecimal purchaseFee;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false, precision = FEE_RATE_PRECISION, scale = FEE_RATE_SCALE)
    private BigDecimal maxRedemptionFee;

}
