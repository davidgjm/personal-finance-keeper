package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface FundCompanyRepository extends BaseRepository<FundCompany> {
    Optional<FundCompany> findByNameIgnoreCase(@NotBlank String name);
}
