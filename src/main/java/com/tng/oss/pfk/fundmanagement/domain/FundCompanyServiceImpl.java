package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
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
    public FundCompanyDto save(@Valid @NotNull FundCompanyDto companyDto) {
        GenericAssertions.notNull(companyDto, "dto cannot be null");
        log.info("Attempting to create fund company: dto details: {}", companyDto);

        FundCompany target;
        Optional<FundCompany> companyOptional = repository.findByNameIgnoreCase(companyDto.getName());

        if (companyOptional.isPresent()) {
            target = companyOptional.get();
            log.info("Fund company with name already exists. {}", target);
            target.setShortName(companyDto.getShortName());
            target.setVentureType(companyDto.getVentureType());
            target.setRegistryLocation(companyDto.getRegistryLocation());
            target.setOfficeLocation(companyDto.getOfficeLocation());
        } else {
            log.info("Creating new fund company with details: {}", companyDto);
            target = companyDtoMapper.asModel(companyDto);
        }
        log.info("Fund company to be saved. {}", target);
        return companyDtoMapper.asDto(repository.save(target));
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

}
