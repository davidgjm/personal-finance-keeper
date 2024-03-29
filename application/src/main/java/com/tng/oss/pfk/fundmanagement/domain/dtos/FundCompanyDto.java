package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.vo.VentureType;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.Instant;
import java.time.LocalDate;

@Valid
@Data
@Builder
public class FundCompanyDto {
    @Positive
    private Long id;

    @NotBlank
    private String name;

    private String fullName;
    private VentureType ventureType;
    private LocalDate established;
    private String registeredLocation;
    private String officeLocation;
    private Instant created;
    private Instant updated;
}
