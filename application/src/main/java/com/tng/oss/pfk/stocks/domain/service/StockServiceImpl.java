package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import com.tng.oss.pfk.stocks.StockInfoError;
import com.tng.oss.pfk.stocks.StockInfoException;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import com.tng.oss.pfk.stocks.domain.model.Stock;
import com.tng.oss.pfk.stocks.domain.repository.IndustryRepository;
import com.tng.oss.pfk.stocks.domain.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.tng.oss.pfk.stocks.StockInfoError.INDUSTRY_NOT_FOUND;
import static com.tng.oss.pfk.stocks.StockInfoError.STOCK_CODE_ALREADY_EXISTS;

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
    public StockDto newStock(StockDto stockDto) {
        log.info("Attempting to create new stock with data: {}", stockDto);
        repository.findByCodeIgnoreCase(stockDto.getCode())
                .ifPresent(stock -> {
                    throw new StockInfoException(STOCK_CODE_ALREADY_EXISTS);
                });
        GenericAssertions.notNull(stockDto.getIndustryId(), "Industry ID is required!");
        boolean industryExists = industryRepository.existsById(stockDto.getIndustryId());
        if (!industryExists) {
            log.error("Industry ID #{} does not exist!", stockDto.getIndustryId());
            throw new StockInfoException(INDUSTRY_NOT_FOUND);
        }
        var entity = repository.save(Stock.create(stockDto));
        log.info("Created stock entity: {}", entity);
        return StockDto.from(entity);
    }

    @Override
    public StockDto findStock(String code) {
        log.info("Attempting to find stock [code={}]", code);
        return repository.findByCodeIgnoreCase(code)
                .map(StockDto::from)
                .orElseThrow(() -> new StockInfoException(StockInfoError.STOCK_NOT_FOUND));
    }

    @Override
    public Page<StockDto> findAll(Pageable pageable) {
        log.info("Attempting to find all stocks with page request {}", pageable);
        return repository.findAll(pageable).map(StockDto::from);
    }
}
