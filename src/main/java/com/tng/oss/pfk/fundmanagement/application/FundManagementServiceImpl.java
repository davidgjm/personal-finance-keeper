package com.tng.oss.pfk.fundmanagement.application;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerComment;
import com.tng.oss.pfk.fundmanagement.domain.service.FundCompanyService;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import com.tng.oss.pfk.fundmanagement.domain.service.FundManagerService;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementError;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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
    public Page<FundCompanyDto> findAllCompanies(PageRequest pageRequest) {
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
    public Page<FundManagerDto> allManagers(PageRequest pageRequest) {
        return managerService.all(pageRequest);
    }

    @Override
    public Page<FundManagerDto> allManagers(Long companyId, PageRequest pageRequest) {
        return managerService.all(companyId,pageRequest);
    }

    @Override
    public FundManagerDto manager(Long managerId) {
        return managerService.of(managerId).orElseThrow(() -> new FundManagementException(FundManagementError.MANAGER_NOT_FOUND));
    }

    @Override
    public List<FundManagerDto> manager(String name) {
        return managerService.of(name);
    }

    @Override
    public FundManagerDto create(FundManagerDto managerDto) {
        return managerService.create(managerDto);
    }

    @Override
    public FundManagerDto update(FundManagerDto managerDto) {
        return managerService.update(managerDto);
    }

    @Override
    public List<FundManagerComment> findComments(Long managerId) {
        log.info("Finding comments for fund manager #{}", managerId);
        var manager = managerService.of(managerId);
        if (manager.isEmpty()) {
            return Collections.emptyList();
        }
        var comments = manager.get().getComments();
        comments.sort(Comparator.comparing(FundManagerComment::getCommentedOn).reversed());
        return comments;
    }

    @Override
    public FundManagerDto commentOnFundManager(String comment, Long managerId) {
        return managerService.addNote(comment, managerId);
    }
}
