package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagementRecordDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public interface FundManagementRecordService {
    List<FundManagementRecordDto> findRecordsByManager(@NotNull @Positive Long managerId);
}
