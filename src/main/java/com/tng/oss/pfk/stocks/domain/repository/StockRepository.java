package com.tng.oss.pfk.stocks.domain.repository;

import com.tng.oss.pfk.stocks.domain.model.Stock;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;

import java.util.Optional;

public interface StockRepository extends BaseRepository<Stock> {
    Optional<Stock> findByCodeIgnoreCase(String code);
}
