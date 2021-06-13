package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public interface FundCompanyService {
    FundCompanyDto save(@Valid @NotNull FundCompanyDto companyDto);

    Page<FundCompanyDto> findAll(@NotNull Pageable pageable);

    Optional<FundCompanyDto> findById(@NotNull @Positive Long companyId);
}
