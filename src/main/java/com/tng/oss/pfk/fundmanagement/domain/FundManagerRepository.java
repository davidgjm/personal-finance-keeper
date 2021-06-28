package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FundManagerRepository extends BaseRepository<FundManager> {
    Page<FundManager> findByCompanyId(Long companyId, Pageable pageable);

    List<FundManager> findByNameIgnoreCase(String name);
}
