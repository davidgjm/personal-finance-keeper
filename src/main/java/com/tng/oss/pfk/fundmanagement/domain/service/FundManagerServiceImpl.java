package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.FundManager;
import com.tng.oss.pfk.fundmanagement.domain.FundManagerDtoMapper;
import com.tng.oss.pfk.fundmanagement.domain.FundManagerNote;
import com.tng.oss.pfk.fundmanagement.domain.FundManagerRepository;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementError;
import com.tng.oss.pfk.fundmanagement.infrastructure.FundManagementException;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Validated
public class FundManagerServiceImpl implements FundManagerService {
    private final FundManagerRepository repository;
    private final FundManagerDtoMapper dtoMapper;

    public FundManagerServiceImpl(FundManagerRepository repository, FundManagerDtoMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Page<FundManagerDto> all(PageRequest pageRequest) {
        GenericAssertions.notNull(pageRequest, "Pageable cannot be null!");
        log.info("Finding all fund managers with provided page request: {}", pageRequest);
        return repository.findAll(pageRequest.withSort(managerSortRule()))
                .map(dtoMapper::asDto)
                ;
    }

    @Override
    public Page<FundManagerDto> all(Long companyId, PageRequest pageRequest) {
        GenericAssertions.isPositive(companyId, "Company Id invalid!");
        log.info("Finding all fund managers for companyId={}", companyId);
        var sortedRequest = pageRequest.withSort(managerSortRule());
        return repository.findByCompanyId(companyId, sortedRequest)
                .map(dtoMapper::asDto);
    }

    @Override
    public List<FundManagerDto> of(String name) {
        GenericAssertions.hasText(name);
        log.info("Attempting to find fund manager {}", name);
        return repository.findByNameIgnoreCase(name).stream()
                .map(dtoMapper::asDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Optional<FundManagerDto> of(Long managerId) {
        return repository.findById(managerId).map(dtoMapper::asDto);
    }

    @Override
    public FundManagerDto create(FundManagerDto managerDto) {
        GenericAssertions.notNull(managerDto, "ManagerDTO cannot be null!");
        log.debug("Attempting to save fund manager. Details: {}", managerDto);
        if (managerDto.getId() != null) {
            log.warn("ID value provided. Potential existing entity DTO!");
            throw new FundManagementException(FundManagementError.MANAGER_ID_EXISTS);
        }

        var manager = repository.save(dtoMapper.asModel(managerDto));
        log.debug("Created fund manager: {}", manager);
        return dtoMapper.asDto(manager);
    }

    @Override
    public FundManagerDto update(FundManagerDto managerDto) {
        GenericAssertions.notNull(managerDto, "ManagerDTO cannot be null!");
        log.debug("Attempting to save fund manager. Details: {}", managerDto);
        var id = managerDto.getId();
        FundManager manager = repository.findById(id).orElseThrow(() -> new FundManagementException(FundManagementError.MANAGER_NOT_FOUND));
        if (!manager.getName().equalsIgnoreCase(managerDto.getName())) {
            log.error("Different fund manager name provided! Provided={}, was={}", managerDto.getName(), manager.getName());
            throw new FundManagementException(FundManagementError.MANAGER_NAME_INCONSISTENT);
        }

        log.info("Attempting to update existing manager. id={}", id);
        manager.setCompanyId(managerDto.getCompanyId());
        manager.setTotalManagedAsset(managerDto.getPresentTotalManagedAsset());
        manager.setAnnualReturnRate(managerDto.getAnnualReturnRate());
        manager.setIntroduction(managerDto.getIntroduction());
        manager.setInvestingStyle(managerDto.getInvestingStyle());

        manager = repository.save(dtoMapper.asModel(managerDto));
        log.debug("Updated fund manager: {}", manager);
        return dtoMapper.asDto(manager);
    }

    @Transactional
    @Override
    public FundManagerDto addNote(String note, Long managerId) {
        log.info("Attempting to add note to fund manager (managerId={})", managerId);
        GenericAssertions.notNull(managerId, "ManagerId cannot be null!");
        GenericAssertions.isPositive(managerId, "ManagerId invalid");
        GenericAssertions.hasText(note);
        var manager = repository.findById(managerId).orElseThrow(() -> new FundManagementException(FundManagementError.MANAGER_NOT_FOUND));
        manager.addComment(FundManagerNote.of(note));
        return dtoMapper.asDto(repository.save(manager));
    }


    private Sort managerSortRule() {
        Sort.TypedSort<FundManager> manager = Sort.sort(FundManager.class);
        return manager.by(FundManager::getName).ascending();
    }
}
