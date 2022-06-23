package com.tng.oss.pfk.stocks.domain.dto;

import com.tng.oss.pfk.stocks.domain.model.Stock;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
public final class StockDto {
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Long industryId;

    private String description;

    public static StockDto from(@NotNull Stock stock) {
        return StockDto.builder()
                .id(stock.getId())
                .code(stock.getCode())
                .name(stock.getName())
                .description(stock.getDescription())
                .industryId(stock.getIndustryId())
                .build();
    }
}
