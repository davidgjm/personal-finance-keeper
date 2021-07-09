package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

public interface StockService {
    IndustryDto newIndustry(@NotBlank String code, @NotBlank String name, @Positive Long parentId);

    List<IndustryDto> findTopLevelIndustries();

    StockDto findStock(@NotBlank String code);
}
