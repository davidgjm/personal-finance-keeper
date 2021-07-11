package com.tng.oss.pfk.fund.presentation.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.fund.domain.dto.FundBasicsDto;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public final class FundBasicsInfoApiData {
    @Positive
    private Long id;

    @NotNull
    @Positive
    @JsonProperty(required = true)
    private Long companyId;

    @NotBlank
    @JsonProperty(required = true)
    private String code;

    @NotBlank
    @JsonProperty(required = true)
    private String name;

    @NotBlank
    @JsonProperty(required = true)
    private String fullName;

    @NotNull
    @JsonProperty(required = true)
    private FundType type;

    @NotNull
    @Past
    @JsonProperty(required = true)
    private LocalDate established;

    @NotBlank
    @JsonProperty(required = true)
    private String performanceBenchmark;

    @NotNull
    @JsonProperty(required = true)
    private FundPurchaseInfoApiData purchaseInfo;

    public static FundBasicsInfoApiData from(FundBasicsDto dto) {
        FundPurchaseInfoApiData purchaseInfoApiData = FundPurchaseInfoApiData.from(dto.getPurchaseInfo());
        var apiData = new FundBasicsInfoApiData();
        apiData.setId(dto.getId());
        apiData.setCompanyId(dto.getCompanyId());
        apiData.setCode(dto.getCode());
        apiData.setName(dto.getName());
        apiData.setFullName(dto.getFullName());
        apiData.setType(dto.getType());
        apiData.setEstablished(dto.getEstablished());
        apiData.setPerformanceBenchmark(dto.getPerformanceBenchmark());
        apiData.setPurchaseInfo(purchaseInfoApiData);
        return apiData;
    }

    public FundBasicsDto asDto() {
        return FundBasicsDto.builder()
                .id(id)
                .companyId(companyId)
                .code(code)
                .name(name)
                .fullName(fullName)
                .type(type)
                .established(established)
                .performanceBenchmark(performanceBenchmark)
                .purchaseInfo(purchaseInfo.asDto())
                .build();
    }
}
