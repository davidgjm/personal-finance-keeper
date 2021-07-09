package com.tng.oss.pfk.stocks.application;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.service.IndustryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Service
@Validated
public class StockInformationServiceImpl implements StockInformationService {
    private final IndustryService industryService;

    public StockInformationServiceImpl(IndustryService industryService) {
        this.industryService = industryService;
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
}
