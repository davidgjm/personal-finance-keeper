package com.tng.oss.pfk.fund.domain.service;

import com.tng.oss.pfk.fund.FundInfoError;
import com.tng.oss.pfk.fund.FundInfoException;
import com.tng.oss.pfk.fund.domain.dto.FundBasicsDto;
import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.model.FundBasicInfo;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import com.tng.oss.pfk.fund.domain.repository.FundBasicInfoRepository;
import com.tng.oss.pfk.fund.domain.specification.FundBasicInfoSpecs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Period;

@Slf4j
@Service
@Validated
public class FundBasicsServiceImpl implements FundBasicsService {
    private final FundBasicInfoRepository repository;

    public FundBasicsServiceImpl(FundBasicInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public FundBasicsDto newFund(FundBasicsDto basicsDto) {
        log.info("Attempting to create new fund with data: {}", basicsDto);
        var existingOptional = repository.findByCodeIgnoreCase(basicsDto.getCode());
        existingOptional.ifPresent(existing -> {
            log.error("Fund with code {} already exists! details: {}", basicsDto.getCode(), existing);
            throw new FundInfoException(FundInfoError.FUND_ALREADY_EXISTS);
        });
        var entity = repository.save(FundBasicInfo.newFund(basicsDto));
        return FundBasicsDto.from(entity);
    }

    @Override
    public FundBasicsDto withId(Long fundId) {
        log.info("Attempting to load fund basic details for #{}", fundId);
        var fund = repository.findById(fundId).orElseThrow(() -> {
            throw new FundInfoException(FundInfoError.FUND_NOT_FOUND);
        });
        return FundBasicsDto.from(fund);
    }

    @Override
    public FundBasicsDto withCode(String code) {
        log.info("Attempting to load fund basic details with code {}", code);
        var fund = repository.findByCodeIgnoreCase(code).orElseThrow(() -> {
            throw new FundInfoException(FundInfoError.FUND_NOT_FOUND);
        });
        return FundBasicsDto.from(fund);
    }

    @Override
    public Page<FundBasicsDto> findByType(FundType type, Pageable pageable) {
        log.info("Attempting to find funds with type {} with page request {}", type, pageable);
        return repository.findAll(FundBasicInfoSpecs.ofType(type), pageable)
                .map(FundBasicsDto::from);
    }

    @Override
    public Page<FundBasicsDto> findFundAboveAge(Period age, Pageable pageable) {
        log.info("Attempting to find funds older than {} with page request {}", age, pageable);
        return repository.findAll(FundBasicInfoSpecs.olderThan(age), pageable)
                .map(FundBasicsDto::from);
    }

    @Override
    public Page<FundBasicsDto> findAll(FundSearchFilter searchFilter, Pageable pageable) {
        log.info("Finding all fund basic items with page request: {}, search filter: {}", pageable, searchFilter);
        if (searchFilter == null || searchFilter.isEmpty()) {
            return repository.findAll(pageable).map(FundBasicsDto::from);
        }

        return repository.findAll(FundBasicInfoSpecs.composite(searchFilter), pageable).map(FundBasicsDto::from);
    }
}
