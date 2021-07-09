package com.tng.oss.pfk.stocks.domain.dto;

import com.tng.oss.pfk.stocks.domain.model.Stock;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
public final class StockDto {
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotNull
    private IndustryDto industry;

    private String description;

    public static StockDto from(@NotNull Stock stock) {
        return StockDto.builder()
                .id(stock.getId())
                .code(stock.getCode())
                .name(stock.getName())
                .description(stock.getDescription())
                .industry(IndustryDto.from(stock.getIndustry()))
                .build();
    }
}
