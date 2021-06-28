package com.tng.oss.pfk.fundmanagement.presentation.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tng.oss.pfk.domain.common.model.vo.AssetVolume;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Builder
@Data
public final class ManagerApiData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Positive
    private Long id;
    private String name;
    private LocalDate careerStarted;
    private Long companyId;
    private AssetVolume presentTotalManagedAsset;
    private BigDecimal annualReturnRate;
    private BigDecimal bestReturnRate;
    private String introduction;
    private String investingStyle;
    private Instant created;
    private Instant updated;

    public static ManagerApiData from(FundManagerDto dto) {
        return ManagerApiData.builder()
                .id(dto.getId())
                .name(dto.getName())
                .careerStarted(dto.getCareerStarted())
                .companyId(dto.getCompanyId())
                .presentTotalManagedAsset(dto.getPresentTotalManagedAsset())
                .annualReturnRate(dto.getAnnualReturnRate())
                .bestReturnRate(dto.getBestReturnRate())
                .introduction(dto.getIntroduction())
                .investingStyle(dto.getInvestingStyle())
                .created(dto.getCreated())
                .updated(dto.getUpdated())
                .build();
    }

    public FundManagerDto asDto() {
        return FundManagerDto.builder()
                .id(id)
                .name(name)
                .careerStarted(careerStarted)
                .companyId(companyId)
                .presentTotalManagedAsset(presentTotalManagedAsset)
                .annualReturnRate(annualReturnRate)
                .bestReturnRate(bestReturnRate)
                .introduction(introduction)
                .investingStyle(investingStyle)
                .created(created)
                .updated(updated)
                .build();
    }
}
