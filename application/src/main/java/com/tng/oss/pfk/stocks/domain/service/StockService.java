package com.tng.oss.pfk.stocks.domain.service;

import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface StockService {
    StockDto newStock(@NotNull @Valid StockDto stockDto);

    StockDto findStock(@NotBlank String code);

    Page<StockDto> findAll(@NotNull Pageable pageable);
}
