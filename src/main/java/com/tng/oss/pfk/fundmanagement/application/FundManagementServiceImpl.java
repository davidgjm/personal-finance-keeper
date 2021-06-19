package com.tng.oss.pfk.fundmanagement.application;

import com.tng.oss.pfk.fundmanagement.domain.FundCompanyService;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import com.tng.oss.pfk.fundmanagement.domain.service.FundManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FundManagementServiceImpl implements FundManagementService {
    private final FundCompanyService companyService;
    private final FundManagerService managerService;
    public FundManagementServiceImpl(FundCompanyService companyService, FundManagerService managerService) {
        this.companyService = companyService;
        this.managerService = managerService;
    }

    @Override
    public FundCompanyDto create(FundCompanyDto companyDto) {
        return companyService.create(companyDto);
    }

    @Override
    public FundCompanyDto update(FundCompanyDto companyDto) {
        return companyService.update(companyDto);
    }

    @Override
    public Page<FundCompanyDto> findAllCompanies(Pageable pageRequest) {
        return companyService.findAll(pageRequest);
    }

    @Override
    public Optional<FundCompanyDto> findCompany(Long companyId) {
        return companyService.findById(companyId);
    }

    @Override
    public Optional<FundCompanyDto> findCompany(String name) {
        return companyService.findByName(name);
    }

    @Override
    public List<FundManagerDto> allManagers(Long companyId) {
        return managerService.all(companyId);
    }

    @Override
    public Optional<FundManagerDto> manager(Long managerId) {
        return managerService.of(managerId);
    }

    @Override
    public List<FundManagerDto> manager(String name) {
        return managerService.of(name);
    }

    @Override
    public FundManagerDto addOrUpdateFundManager(FundManagerDto managerDto) {
        return managerService.save(managerDto);
    }

    @Override
    public FundManagerDto commentOnFundManager(String comment, Long managerId) {
        return managerService.addNote(comment, managerId);
    }
}
