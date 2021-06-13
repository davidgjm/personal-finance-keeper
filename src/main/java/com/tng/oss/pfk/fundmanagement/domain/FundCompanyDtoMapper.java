package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
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
                .shortName(source.getShortName())
                .ventureType(source.getVentureType())
                .established(source.getEstablished())
                .registryLocation(source.getRegistryLocation())
                .officeLocation(source.getOfficeLocation())
                .build();
    }

    @Override
    public FundCompany asModel(FundCompanyDto dto) {
        return FundCompany.of(dto.getName(), dto.getShortName(), dto.getVentureType(), dto.getEstablished(), dto.getRegistryLocation(), dto.getOfficeLocation());
    }
}
