package com.tng.oss.pfk.fund.application;

import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.dto.FundBasicsDto;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Period;

public interface FundApplicationService {

    FundBasicsDto newFund(@NotNull FundBasicsDto requestDto);

    FundBasicsDto withId(@NotNull @Positive Long fundId);

    FundBasicsDto withCode(@NotBlank String fundCode);

    Page<FundBasicsDto> allBasicItems(FundSearchFilter searchFilter, Pageable pageable);

    Page<FundBasicsDto> findByType(@NotNull FundType type, Pageable pageable);

    Page<FundBasicsDto> findFundAboveAge(@NotNull Period age, Pageable pageable);
}
