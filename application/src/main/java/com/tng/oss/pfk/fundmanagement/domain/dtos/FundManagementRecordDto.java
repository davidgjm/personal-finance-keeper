package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.model.FundManagementRecord;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Builder
@Data
public final class FundManagementRecordDto {
    private Long id;

    @NotNull
    @Positive
    private Long fundId;

    @NotNull
    @Positive
    private Long managerId;

    @NotNull
    @Past
    private LocalDate start;

    @PastOrPresent
    private LocalDate finish;

    @NotNull
    private Period period;

    @NotNull
    private BigDecimal returnRate;

    public static FundManagementRecordDto from(FundManagementRecord record) {
        return FundManagementRecordDto.builder()
                .id(record.getId())
                .fundId(record.getFundId())
                .managerId(record.getManagerId())
                .start(record.getStart())
                .finish(record.getFinish())
                .period(record.getPeriod())
                .returnRate(record.getReturnRate())
                .build();
    }
}
