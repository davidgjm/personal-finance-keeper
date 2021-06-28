package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.FundCompany;
import com.tng.oss.pfk.fundmanagement.domain.FundCompanyDtoMapper;
import com.tng.oss.pfk.fundmanagement.domain.FundCompanyRepository;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementError;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementException;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Slf4j
@Service
public class FundCompanyServiceImpl implements FundCompanyService {
    private final FundCompanyRepository repository;
    private final FundCompanyDtoMapper companyDtoMapper;

    public FundCompanyServiceImpl(FundCompanyRepository repository, FundCompanyDtoMapper companyDtoMapper) {
        this.repository = repository;
        this.companyDtoMapper = companyDtoMapper;
    }

    @Override
    public FundCompanyDto create(@Valid @NotNull FundCompanyDto companyDto) {
        GenericAssertions.notNull(companyDto, "dto cannot be null");
        log.info("Attempting to create fund company: dto details: {}", companyDto);

        FundCompany target;
        Optional<FundCompany> companyOptional = repository.findByNameIgnoreCase(companyDto.getName());
        companyOptional.ifPresent(c -> {
            log.error("Fund company with name already exists. {}", c.getName());
            throw new FundManagementException(FundManagementError.COMPANY_NAME_ALREADY_EXISTS);
        });
        log.info("Creating new fund company with details: {}", companyDto);
        target = companyDtoMapper.asModel(companyDto);
        log.info("Fund company to be saved. {}", target);
        return companyDtoMapper.asDto(repository.save(target));
    }

    @Override
    public FundCompanyDto update(FundCompanyDto companyDto) {
        GenericAssertions.notNull(companyDto, "dto cannot be null");
        GenericAssertions.notNull(companyDto.getId(), "ID cannot be null");
        log.info("Attempting to update fund company: dto details: {}", companyDto);
        FundCompany company = repository.findById(companyDto.getId()).orElseThrow(() -> new FundManagementException(FundManagementError.COMPANY_NOT_FOUND));
        if (!companyDto.getName().contentEquals(company.getName())) {
            log.error("Provided company name is different from existing! Provided={}, existing={}", companyDto.getName(), company.getName());
            throw new FundManagementException(FundManagementError.COMPANY_NAME_MISMATCH);
        }

        company.setShortName(companyDto.getShortName());
        company.setVentureType(companyDto.getVentureType());
        company.setRegistryLocation(companyDto.getRegistryLocation());
        company.setOfficeLocation(companyDto.getOfficeLocation());
        return companyDtoMapper.asDto(repository.save(company));
    }

    @Override
    public Page<FundCompanyDto> findAll(@NotNull Pageable pageable) {
        log.info("Attempting to find all fund companies with paging info: [pageable={}]", pageable);
        return repository.findAll(pageable)
                .map(companyDtoMapper::asDto)
                ;
    }

    @Override
    public Optional<FundCompanyDto> findById(Long companyId) {
        log.info("Attempting to find fund company: [companyId={}]", companyId);
        return repository.findById(companyId).map(companyDtoMapper::asDto);
    }

    @Override
    public Optional<FundCompanyDto> findByName(String name) {
        log.info("Attempting to find company by name or short name: {}", name);
        return repository.findByNameOrShortNameIgnoreCase(name).map(companyDtoMapper::asDto);
    }

}
