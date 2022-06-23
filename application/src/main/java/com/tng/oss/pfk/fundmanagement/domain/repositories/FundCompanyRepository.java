package com.tng.oss.pfk.fundmanagement.domain.repositories;

import com.tng.oss.pfk.fundmanagement.domain.model.FundCompany;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface FundCompanyRepository extends BaseRepository<FundCompany> {
    Optional<FundCompany> findByNameIgnoreCase(@NotBlank String name);

    @Query("SELECT c FROM FundCompany c WHERE c.name = :name OR c.fullName = :name")
    Optional<FundCompany> findByNameOrFullNameIgnoreCase(@NotBlank String name);
}
