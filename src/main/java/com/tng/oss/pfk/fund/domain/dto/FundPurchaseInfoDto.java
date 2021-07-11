package com.tng.oss.pfk.fund.domain.dto;

import com.tng.oss.pfk.fund.domain.model.vo.FundPurchaseInfo;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Builder
@Data
public final class FundPurchaseInfoDto {

    @NotNull
    @Positive
    private BigDecimal annualManagementFee;

    @NotNull
    @Positive
    private BigDecimal custodianFee;

    @NotNull
    @PositiveOrZero
    private BigDecimal salesServiceFee;


    @NotNull
    @PositiveOrZero
    private BigDecimal purchaseFee;

    @NotNull
    @PositiveOrZero
    private BigDecimal maxRedemptionFee;

    public static FundPurchaseInfoDto from(FundPurchaseInfo purchaseInfo) {
        return FundPurchaseInfoDto.builder()
                .annualManagementFee(purchaseInfo.getAnnualManagementFee())
                .custodianFee(purchaseInfo.getCustodianFee())
                .salesServiceFee(purchaseInfo.getSalesServiceFee())
                .purchaseFee(purchaseInfo.getPurchaseFee())
                .maxRedemptionFee(purchaseInfo.getMaxRedemptionFee())
                .build();
    }

    public FundPurchaseInfo asValueObject() {
        var vo = new FundPurchaseInfo();
        vo.setAnnualManagementFee(annualManagementFee);
        vo.setCustodianFee(custodianFee);
        vo.setSalesServiceFee(salesServiceFee);
        vo.setPurchaseFee(purchaseFee);
        vo.setMaxRedemptionFee(maxRedemptionFee);
        return vo;
    }
}
