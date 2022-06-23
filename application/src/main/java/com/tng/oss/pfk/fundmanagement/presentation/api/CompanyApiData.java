package com.tng.oss.pfk.fundmanagement.presentation.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.fundmanagement.domain.vo.VentureType;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundCompanyDto;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.Instant;
import java.time.LocalDate;

@Builder
@Data
public final class CompanyApiData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Positive
    private Long id;

    @NotBlank
    @JsonProperty(required = true)
    private String name;

    @NotBlank
    @JsonProperty(required = true)
    private String fullName;

    @NotNull
    @JsonProperty(required = true)
    private CompanyType type;

    @NotNull
    @Past
    @JsonProperty(required = true)
    private LocalDate established;

    private String registeredLocation;

    private String officeLocation;
    private Instant created;
    private Instant updated;

    public FundCompanyDto asDto() {
        return FundCompanyDto.builder()
                .id(id)
                .name(name)
                .fullName(fullName)
                .ventureType(VentureType.valueOf(type.name()))
                .established(established)
                .registeredLocation(registeredLocation)
                .officeLocation(officeLocation)
                .build()
                ;
    }

    public static CompanyApiData from(FundCompanyDto companyDto) {
        GenericAssertions.notNull(companyDto, "CompanyDto cannot be null!");
        return CompanyApiData.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .fullName(companyDto.getFullName())
                .type(CompanyType.valueOf(companyDto.getVentureType().name()))
                .established(companyDto.getEstablished())
                .registeredLocation(companyDto.getRegisteredLocation())
                .officeLocation(companyDto.getOfficeLocation())
                .created(companyDto.getCreated())
                .updated(companyDto.getUpdated())
                .build();
    }
}
