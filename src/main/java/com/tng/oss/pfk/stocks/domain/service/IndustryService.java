package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public interface IndustryService {
    IndustryDto newIndustry(@NotBlank String code, @NotBlank String name, @Positive Long parentId);

    IndustryDto withId(@NotNull @Positive Long id);

    List<IndustryDto> findTopLevelIndustries();

    List<IndustryDto> findIndustriesByParentId(@NotNull @Positive Long parentId, @NotNull Sort sort);
}
