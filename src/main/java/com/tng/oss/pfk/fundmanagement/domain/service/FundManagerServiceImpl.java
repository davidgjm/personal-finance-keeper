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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FundManagerServiceImpl implements FundManagerService {
    private final FundManagerRepository repository;
    private final FundManagerDtoMapper dtoMapper;

    public FundManagerServiceImpl(FundManagerRepository repository, FundManagerDtoMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<FundManagerDto> all(Long companyId) {
        GenericAssertions.isPositive(companyId, "Company Id invalid!");
        log.info("Finding all fund managers for companyId={}", companyId);
        return repository.findByCompanyId(companyId).stream()
                .map(dtoMapper::asDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FundManagerDto> of(String name) {
        GenericAssertions.hasText(name);
        log.info("Attempting to find fund manager {}", name);
        return repository.findByNameIgnoreCase(name).stream()
                .map(dtoMapper::asDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FundManagerDto> of(Long managerId) {
        return repository.findById(managerId).map(dtoMapper::asDto);
    }

    @Override
    public FundManagerDto save(FundManagerDto managerDto) {
        GenericAssertions.notNull(managerDto, "ManagerDTO cannot be null!");
        log.debug("Attempting to save fund manager. Details: {}", managerDto);
        var id = managerDto.getId();
        FundManager manager = null;
        if (id == null) {
            log.info("Attempting to create new manager (ID is null). Details: {}", managerDto);
            manager = repository.save(dtoMapper.asModel(managerDto));
            log.debug("Saved manager entity. id={}, details={}", manager.getId(), manager);
        } else {
            log.info("Attempting to update existing manager. id={}", id);
            manager = repository.findById(id).orElseThrow(() -> new FundManagementException(FundManagementError.MANAGER_NOT_FOUND));
        }
        log.debug("Created/Loaded fund manager: {}", manager);
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
}
