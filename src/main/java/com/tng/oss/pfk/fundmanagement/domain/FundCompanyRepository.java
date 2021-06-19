package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface FundCompanyRepository extends BaseRepository<FundCompany> {
    Optional<FundCompany> findByNameIgnoreCase(@NotBlank String name);

    @Query("SELECT c FROM FundCompany c WHERE c.name = :name OR c.shortName = :name")
    Optional<FundCompany> findByNameOrShortNameIgnoreCase(@NotBlank String name);
}
