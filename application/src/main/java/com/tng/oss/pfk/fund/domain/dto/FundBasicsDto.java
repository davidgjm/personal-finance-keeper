package com.tng.oss.pfk.fund.domain.dto;

import com.tng.oss.pfk.fund.domain.model.FundBasicInfo;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Builder
@Data
@Validated
public final class FundBasicsDto {
    private Long id;

    @NotNull
    @Positive
    private Long companyId;

    @NotBlank
    private String code;

    @NotBlank
    private String name;
    @NotBlank
    private String fullName;

    @NotNull
    private FundType type;

    @NotNull
    @Past
    private LocalDate established;

    @NotBlank
    private String performanceBenchmark;

    @NotNull
    private FundPurchaseInfoDto purchaseInfo;

    public static FundBasicsDto from(FundBasicInfo basicInfo) {
        return FundBasicsDto.builder()
                .id(basicInfo.getId())
                .companyId(basicInfo.getCompanyId())
                .code(basicInfo.getCode())
                .name(basicInfo.getName())
                .fullName(basicInfo.getFullName())
                .type(basicInfo.getType())
                .established(basicInfo.getEstablished())
                .performanceBenchmark(basicInfo.getPerformanceBenchmark())
                .purchaseInfo(FundPurchaseInfoDto.from(basicInfo.getPurchaseInfo()))
                .build();
    }
}
