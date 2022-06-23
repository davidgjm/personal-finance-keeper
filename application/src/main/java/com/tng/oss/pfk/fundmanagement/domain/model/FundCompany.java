package com.tng.oss.pfk.fundmanagement.domain.model;

import com.tng.oss.pfk.fundmanagement.domain.vo.VentureType;
import com.tng.oss.pfk.infrastructure.core.persistence.AuditableEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_fund_company_name", columnNames = {"name"})
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class FundCompany extends AuditableEntity {


    @NotBlank
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private String name;

    @EqualsAndHashCode.Include
    @NotBlank
    @Column(length = 16)
    private String fullName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private VentureType ventureType;

    @Past
    private LocalDate established;

    @Column(length = 40)
    private String registeredLocation;

    @Column(length = 40)
    private String officeLocation;

    public void setFullName(String fullName) {
        if (StringUtils.hasText(fullName)) {
            this.fullName = fullName;
        }
    }

    public void setVentureType(VentureType ventureType) {
        Assert.notNull(ventureType, "Venture type cannot be null!");
        this.ventureType = ventureType;
    }

    public void setEstablished(LocalDate established) {
        if (this.established != null) {
            return;
        }
        GenericAssertions.isPast(established, "Established date cannot be present or future!");
        this.established = established;
    }

    public void setRegisteredLocation(String registeredLocation) {
        if (StringUtils.hasText(registeredLocation)) {
            this.registeredLocation = registeredLocation;
        }
    }

    public void setOfficeLocation(String officeLocation) {
        if (StringUtils.hasText(officeLocation)) {
            this.officeLocation = officeLocation;
        }
    }

    public static FundCompany create(@NotBlank String name, String fullName, VentureType ventureType,
                                     @NotNull @Past LocalDate established,
                                     String registryLocation,
                                     String officeLocation) {
        Assert.hasText(name, "Company name is required!");
        GenericAssertions.isPast(established, "Established date cannot be present or future");
        return new FundCompany(name, fullName, ventureType, established, registryLocation, officeLocation);
    }
}
