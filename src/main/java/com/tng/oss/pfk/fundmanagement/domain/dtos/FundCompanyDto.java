package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.VentureType;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Valid
@Data
@Builder
public class FundCompanyDto {
    private Long id;

    @NotBlank
    private String name;

    private String shortName;
    private VentureType ventureType;
    private LocalDate established;
    private String registryLocation;
    private String officeLocation;
}
