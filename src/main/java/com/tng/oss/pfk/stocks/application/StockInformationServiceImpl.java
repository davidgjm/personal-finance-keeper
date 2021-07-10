package com.tng.oss.pfk.stocks.application;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import com.tng.oss.pfk.stocks.domain.service.IndustryService;
import com.tng.oss.pfk.stocks.domain.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Service
@Validated
public class StockInformationServiceImpl implements StockInformationService {
    private final IndustryService industryService;
    private final StockService stockService;

    public StockInformationServiceImpl(IndustryService industryService, StockService stockService) {
        this.industryService = industryService;
        this.stockService = stockService;
    }

    @Override
    public IndustryDto newIndustry(String code, String name, Long parentId) {
        return industryService.newIndustry(code, name, parentId);
    }

    @Override
    public IndustryDto findIndustryById(Long id) {
        return industryService.withId(id);
    }

    @Override
    public List<IndustryDto> findTopLevelIndustries() {
        return industryService.findTopLevelIndustries();
    }

    @Override
    public List<IndustryDto> findIndustriesByParentId(Long parentId) {
        return industryService.findIndustriesByParentId(parentId, Sort.by("code"));
    }

    @Override
    public Page<StockDto> findAllStocks(PageRequest pageRequest) {
        var sorted = pageRequest.withSort(Sort.by("code"));
        return stockService.findAll(sorted);
    }

    @Override
    public StockDto newStock(String code, String name, Long industryId, String description) {
        var dto= StockDto.builder()
                .code(code)
                .name(name)
                .industryId(industryId)
                .description(description)
                .build();
        return stockService.newStock(dto);
    }
}
