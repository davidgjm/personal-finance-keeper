package com.tng.oss.pfk.fund.application;

import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.dto.FundBasicsDto;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import com.tng.oss.pfk.fund.domain.service.FundBasicsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Period;

@Slf4j
@Service
@Validated
public class FundApplicationServiceImpl implements FundApplicationService {
    private final FundBasicsService basicsService;

    public FundApplicationServiceImpl(FundBasicsService basicsService) {
        this.basicsService = basicsService;
    }

    @Override
    public FundBasicsDto newFund(FundBasicsDto requestDto) {
        return basicsService.newFund(requestDto);
    }

    @Override
    public FundBasicsDto withId(Long fundId) {
        return basicsService.withId(fundId);
    }

    @Override
    public FundBasicsDto withCode(String fundCode) {
        return basicsService.withCode(fundCode);
    }

    @Override
    public Page<FundBasicsDto> allBasicItems(FundSearchFilter searchFilter, Pageable pageable) {
        return basicsService.findAll(searchFilter, pageable);
    }

    @Override
    public Page<FundBasicsDto> findByType(FundType type, Pageable pageable) {
        return basicsService.findByType(type, pageable);
    }

    @Override
    public Page<FundBasicsDto> findFundAboveAge(Period age, Pageable pageable) {
        return basicsService.findFundAboveAge(age, pageable);
    }
}
