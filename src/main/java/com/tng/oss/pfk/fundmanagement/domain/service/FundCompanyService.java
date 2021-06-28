package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public interface FundCompanyService {
    FundCompanyDto create(@Valid @NotNull FundCompanyDto companyDto);

    FundCompanyDto update(@Valid @NotNull FundCompanyDto companyDto);

    Page<FundCompanyDto> findAll(@NotNull Pageable pageable);

    Optional<FundCompanyDto> findById(@NotNull @Positive Long companyId);

    /**
     * Finds a company by its name or short name case insensitive
     * @param name company name to be searched
     * @return
     */
    Optional<FundCompanyDto> findByName(@NotBlank String name);
}
