package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;

import java.util.List;

public interface FundManagerRepository extends BaseRepository<FundManager> {
    List<FundManager> findByCompanyId(Long companyId);

    List<FundManager> findByNameIgnoreCase(String name);
}
