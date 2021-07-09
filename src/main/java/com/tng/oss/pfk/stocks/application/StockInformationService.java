package com.tng.oss.pfk.stocks.application;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public interface StockInformationService {
    IndustryDto newIndustry(@NotBlank String code, @NotBlank String name, @Positive Long parentId);

    IndustryDto findIndustryById(@NotNull @Positive Long id);

    List<IndustryDto> findTopLevelIndustries();

    List<IndustryDto> findIndustriesByParentId(@NotNull @Positive Long parentId);

}
