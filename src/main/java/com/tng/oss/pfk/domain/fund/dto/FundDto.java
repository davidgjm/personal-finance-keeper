package com.tng.oss.pfk.domain.fund.dto;

import com.tng.oss.pfk.domain.fund.model.vo.FundPurchaseInfo;
import com.tng.oss.pfk.domain.fund.model.vo.FundType;
import lombok.Data;

import java.time.LocalDate;

@Data
public final class FundDto {
    private Long id;
    private Long companyId;


    private String code;
    private String name;
    private String fullName;
    private FundType type;
    private LocalDate established;
    private String performanceBenchmark;
    private FundPurchaseInfo purchaseInfo;
}
