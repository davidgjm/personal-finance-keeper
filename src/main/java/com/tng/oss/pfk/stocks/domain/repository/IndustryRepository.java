package com.tng.oss.pfk.stocks.domain.repository;

import com.tng.oss.pfk.stocks.domain.model.Industry;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IndustryRepository extends BaseRepository<Industry> {

    List<Industry> findByParentIsNull(Sort sort);

    @Query("SELECT i FROM Industry i WHERE i.parent != null AND i.parent.id = :parentId")
    List<Industry> findByParentId(@Param("parentId") Long parentId, Sort sort);

    Optional<Industry> findByCodeIgnoreCase(String code);

    Optional<Industry> findByNameIgnoreCase(String name);
}
