package com.tng.oss.pfk.stocks.domain.repository;

import com.tng.oss.pfk.stocks.domain.model.Industry;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IndustryRepository extends BaseRepository<Industry> {

    List<Industry> findByParentIsNull(Sort sort);

    List<Industry> findByParentIdNotNull(Long parentId, Sort sort);

    Optional<Industry> findByCodeIgnoreCase(String code);

    Optional<Industry> findByNameIgnoreCase(String name);
}
