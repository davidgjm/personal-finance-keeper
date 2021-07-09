package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.stocks.StockInfoException;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.model.Industry;
import com.tng.oss.pfk.stocks.domain.repository.IndustryRepository;
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
public class IndustryServiceImpl implements IndustryService {
    private final IndustryRepository repository;

    public IndustryServiceImpl(IndustryRepository repository) {
        this.repository = repository;
    }

    @Override
    public IndustryDto newIndustry(String code, String name, Long parentId) {
        log.info("Attempting to create new industry with code={}, name={}, parentId={}", code, name, parentId);
        Optional<Industry> industryOptional = repository.findByCodeIgnoreCase(code);
        industryOptional.ifPresent(industry -> {
            log.error("An entity with the provided code already exists! {}", code);
            throw new StockInfoException(INDUSTRY_CODE_ALREADY_EXISTS);
        });

        Industry parent = null;
        if (parentId != null) {
            log.info("Checking if parent entity #{} exists", parentId);
            parent = repository.findById(parentId).orElseThrow(() -> {
                throw new StockInfoException(INDUSTRY_NOT_FOUND);});
        }
        var entity = Industry.create(code, name, parent);
        entity = repository.save(entity);
        return IndustryDto.from(entity);
    }

    @Override
    public IndustryDto withId(Long id) {
        log.info("Attempting to load industry with id #{}", id);
        return repository.findById(id).map(IndustryDto::from).orElseThrow(() -> {
            throw new StockInfoException(INDUSTRY_NOT_FOUND);});
    }

    @Override
    public List<IndustryDto> findTopLevelIndustries() {
        log.info("Finding all industries...");
        return repository.findByParentIsNull(Sort.by("code").ascending()).stream()
                .map(IndustryDto::from)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<IndustryDto> findIndustriesByParentId(Long parentId, Sort sort) {
        log.info("Attempting to find industries with parent #{} in order {}", parentId, sort);

        return repository.findByParentIdNotNull(parentId, sort).stream()
                .map(IndustryDto::from)
                .collect(Collectors.toList());
    }

}
