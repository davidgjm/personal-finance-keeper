package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.model.FundCompany;
import com.tng.oss.pfk.infrastructure.core.GenericDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FundCompanyDtoMapper implements GenericDtoMapper<FundCompany, FundCompanyDto> {
    @Override
    public FundCompanyDto asDto(FundCompany source) {
        return FundCompanyDto.builder()
                .id(source.getId())
                .name(source.getName())
                .fullName(source.getFullName())
                .ventureType(source.getVentureType())
                .established(source.getEstablished())
                .registeredLocation(source.getRegisteredLocation())
                .officeLocation(source.getOfficeLocation())
                .created(source.getCreated())
                .updated(source.getLastUpdated())
                .build();
    }

    @Override
    public FundCompany asModel(FundCompanyDto dto) {
        return FundCompany.create(dto.getName(), dto.getFullName(), dto.getVentureType(), dto.getEstablished(), dto.getRegisteredLocation(), dto.getOfficeLocation());
    }
}
