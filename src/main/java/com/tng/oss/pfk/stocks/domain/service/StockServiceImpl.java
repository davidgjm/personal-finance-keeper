package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.stocks.StockInfoError;
import com.tng.oss.pfk.stocks.StockInfoException;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import com.tng.oss.pfk.stocks.domain.model.Industry;
import com.tng.oss.pfk.stocks.domain.repository.IndustryRepository;
import com.tng.oss.pfk.stocks.domain.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tng.oss.pfk.stocks.StockInfoError.INDUSTRY_CODE_ALREADY_EXISTS;
import static com.tng.oss.pfk.stocks.StockInfoError.INDUSTRY_NOT_FOUND;

@Slf4j
@Service
@Validated
public class StockServiceImpl implements StockService {
    private final StockRepository repository;
    private final IndustryRepository industryRepository;

    public StockServiceImpl(StockRepository repository, IndustryRepository industryRepository) {
        this.repository = repository;
        this.industryRepository = industryRepository;
    }

    @Override
    public IndustryDto newIndustry(String code, String name, Long parentId) {
        log.info("Attempting to create new industry with code={}, name={}, parentId={}", code, name, parentId);
        Optional<Industry> industryOptional = industryRepository.findByCodeIgnoreCase(code);
        industryOptional.ifPresent(industry -> {
            log.error("An entity with the provided code already exists! {}", code);
            throw new StockInfoException(INDUSTRY_CODE_ALREADY_EXISTS);
        });

        Industry parent = null;
        if (parentId != null) {
            log.info("Checking if parent entity #{} exists", parentId);
            parent = industryRepository.findById(parentId).orElseThrow(() -> {
                throw new StockInfoException(INDUSTRY_NOT_FOUND);});
        }
        var entity = Industry.create(code, name, parent);
        return IndustryDto.from(entity);
    }

    @Override
    public List<IndustryDto> findTopLevelIndustries() {
        log.info("Finding all industries...");
        return industryRepository.findByParentIsNull(Sort.by("code").ascending()).stream()
                .map(IndustryDto::from)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public StockDto findStock(String code) {
        log.info("Attempting to find stock [code={}]", code);
        return repository.findByCode(code)
                .map(StockDto::from)
                .orElseThrow(() -> new StockInfoException(StockInfoError.STOCK_NOT_FOUND));
    }
}
