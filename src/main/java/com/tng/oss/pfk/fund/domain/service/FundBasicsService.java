package com.tng.oss.pfk.fund.domain.service;

import com.tng.oss.pfk.fund.domain.dto.FundBasicsDto;
import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Period;

public interface FundBasicsService {
    FundBasicsDto newFund(@NotNull FundBasicsDto basicsDto);

    FundBasicsDto withId(@NotNull @Positive Long fundId);

    FundBasicsDto withCode(@NotBlank String code);

    Page<FundBasicsDto> findByType(@NotNull FundType type, Pageable pageable);

    Page<FundBasicsDto> findFundAboveAge(@NotNull Period age, Pageable pageable);

    Page<FundBasicsDto> findAll(FundSearchFilter searchFilter, Pageable pageable);
}
