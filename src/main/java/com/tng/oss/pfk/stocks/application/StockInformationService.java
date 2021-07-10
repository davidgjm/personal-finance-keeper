package com.tng.oss.pfk.stocks.application;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public interface StockInformationService {
    IndustryDto newIndustry(@NotBlank String code, @NotBlank String name, @Positive Long parentId);

    IndustryDto findIndustryById(@NotNull @Positive Long id);

    List<IndustryDto> findTopLevelIndustries();

    List<IndustryDto> findIndustriesByParentId(@NotNull @Positive Long parentId);

    Page<StockDto> findAllStocks(@NotNull PageRequest pageRequest);

    StockDto newStock(@NotBlank String code, @NotBlank String name, @NotNull @Positive Long industryId, String description);

}
