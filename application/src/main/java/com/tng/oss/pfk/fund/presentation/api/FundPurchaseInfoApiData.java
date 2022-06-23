package com.tng.oss.pfk.fund.presentation.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.fund.domain.dto.FundPurchaseInfoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public final class FundPurchaseInfoApiData {

    @NotNull
    @Positive
    @JsonProperty(required = true, value = "managementFee")
    private BigDecimal annualManagementFee;

    @NotNull
    @Positive
    @JsonProperty(required = true)
    private BigDecimal custodianFee;

    @NotNull
    @PositiveOrZero
    @JsonProperty(required = false, defaultValue = "0")
    private BigDecimal salesServiceFee;


    @NotNull
    @PositiveOrZero
    @JsonProperty(required = true)
    private BigDecimal purchaseFee;

    @NotNull
    @PositiveOrZero
    @JsonProperty(required = true)
    private BigDecimal maxRedemptionFee;

    public static FundPurchaseInfoApiData from(FundPurchaseInfoDto dto) {
        var apiData = new FundPurchaseInfoApiData();
        apiData.setAnnualManagementFee(dto.getAnnualManagementFee());
        apiData.setCustodianFee(dto.getCustodianFee());
        apiData.setSalesServiceFee(dto.getSalesServiceFee());
        apiData.setPurchaseFee(dto.getPurchaseFee());
        apiData.setMaxRedemptionFee(dto.getMaxRedemptionFee());
        return apiData;
    }

    public FundPurchaseInfoDto asDto() {
        return FundPurchaseInfoDto.builder()
                .annualManagementFee(annualManagementFee)
                .custodianFee(custodianFee)
                .salesServiceFee(salesServiceFee)
                .purchaseFee(purchaseFee)
                .maxRedemptionFee(maxRedemptionFee)
                .build();
    }
}
