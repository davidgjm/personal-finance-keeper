package com.tng.oss.pfk.fundmanagement.domain.model;

import com.tng.oss.pfk.fundmanagement.domain.vo.VentureType;
import com.tng.oss.pfk.infrastructure.core.persistence.AuditableEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.springframework.util.Assert;

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
@Builder
public class FundCompany extends AuditableEntity {


    @EqualsAndHashCode.Include
    @NotBlank
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private String name;

    @NotBlank
    @Column(length = 16)
    @Setter(AccessLevel.PUBLIC)
    private String shortName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private VentureType ventureType;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDate established;

    @Column(length = 40)
    @Setter(AccessLevel.PUBLIC)
    private String registryLocation;

    @Column(length = 40)
    @Setter(AccessLevel.PUBLIC)
    private String officeLocation;

    public void setVentureType(VentureType ventureType) {
        Assert.notNull(ventureType, "Venture type cannot be null!");
        this.ventureType = ventureType;
    }

    @PreUpdate
    @PrePersist
    private void setDefault() {
        if (ventureType == null) {
            this.ventureType = VentureType.DOMESTIC;
        }
    }


    public static FundCompany of(@NotBlank String name, String shortName, VentureType ventureType,
                                 @NotNull @Past LocalDate established,
                                 String registryLocation,
                                 String officeLocation) {
        Assert.hasText(name, "Company name is required!");
        GenericAssertions.isPast(established, "Established date cannot be present or future");
        return new FundCompany(name, shortName, ventureType, established, registryLocation, officeLocation);
    }
}
