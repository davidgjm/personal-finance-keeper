package com.tng.oss.pfk.stocks.presentation.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public final class StockApiData {
    private Long id;

    @NotBlank
    @JsonProperty(required = true)
    private String code;

    @NotBlank
    @JsonProperty(required = true)
    private String name;

    @NotNull
    @Positive
    @JsonProperty(required = true)
    private Long industryId;

    private String description;

    public static StockApiData from(StockDto dto) {
        StockApiData apiData = new StockApiData();
        apiData.setId(dto.getId());
        apiData.setCode(dto.getCode());
        apiData.setName(dto.getName());
        apiData.setIndustryId(dto.getIndustryId());
        apiData.setDescription(dto.getDescription());
        return apiData;
    }
}
