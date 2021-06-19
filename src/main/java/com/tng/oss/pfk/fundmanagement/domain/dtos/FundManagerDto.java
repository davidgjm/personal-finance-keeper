package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.domain.common.model.vo.AssetVolume;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class FundManagerDto {
    private Long id;
    private String fullName;
    private LocalDate careerStarted;
    private Long companyId;
    private AssetVolume presentTotalManagedAsset;
    private BigDecimal annualReturnRate;
    private BigDecimal bestReturnRate;
    private String introduction;
    private String investingStyle;
    private List<FundManagerComment> comments;

}
