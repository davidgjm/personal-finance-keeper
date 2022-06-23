package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagementRecordDto;
import com.tng.oss.pfk.fundmanagement.domain.repositories.FundManagementRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Validated
public class FundManagementRecordServiceImpl implements FundManagementRecordService {
    private final FundManagementRecordRepository repository;

    public FundManagementRecordServiceImpl(FundManagementRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FundManagementRecordDto> findRecordsByManager(Long managerId) {
        log.info("Attempting to find all records for manager #{}", managerId);

        return repository.findAllByManagerId(managerId).stream()
                .map(FundManagementRecordDto::from)
                .collect(Collectors.toList());
    }
}
