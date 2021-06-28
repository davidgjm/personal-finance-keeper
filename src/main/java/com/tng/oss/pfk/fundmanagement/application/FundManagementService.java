package com.tng.oss.pfk.fundmanagement.application;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerComment;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

public interface FundManagementService {
    FundCompanyDto create(@NotNull @Valid FundCompanyDto companyDto);

    FundCompanyDto update(@NotNull @Valid FundCompanyDto companyDto);

    Page<FundCompanyDto> findAllCompanies(@NotNull PageRequest pageRequest);

    Optional<FundCompanyDto> findCompany(@NotNull @Positive Long companyId);

    Optional<FundCompanyDto> findCompany(@NotBlank String name);

    Page<FundManagerDto> allManagers(PageRequest pageRequest);

    Page<FundManagerDto> allManagers(@NotNull @Positive Long companyId, PageRequest pageRequest);

    FundManagerDto manager(@NotNull @Positive Long managerId);

    List<FundManagerDto> manager(@NotBlank String name);

    /**
     * Adds a new fund manager to the company represented by its ID
     * @param managerDto Fund manager DTO to be added
     * @return
     */
    FundManagerDto create(@NotNull @Valid FundManagerDto managerDto);

    FundManagerDto update(@NotNull @Valid FundManagerDto managerDto);

    List<FundManagerComment> findComments(@NotNull @Positive Long managerId);

    FundManagerDto commentOnFundManager(@NotBlank String comment, @NotNull @Positive Long managerId);
}
