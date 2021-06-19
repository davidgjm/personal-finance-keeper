package com.tng.oss.pfk.domain.fund.model;

import com.tng.oss.pfk.domain.common.model.vo.AssetVolume;
import com.tng.oss.pfk.domain.fund.model.vo.FundPurchaseInfo;
import com.tng.oss.pfk.domain.fund.model.vo.FundType;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_fund_code", columnNames = {"code"}),
                @UniqueConstraint(name = "uq_fund_name", columnNames = {"name"}),
        },
        indexes = {
                @Index(name = "idx_fund_code", columnList = "code")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@Builder
public final class Fund extends BaseEntity {

    @Setter(AccessLevel.MODULE)
    @EqualsAndHashCode.Include
    @NotBlank
    @Pattern(regexp = "\\d{6}")
    @Column(nullable = false, updatable = false, length = 6)
    private String code;


    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String fullName;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FundType type;

    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    private Long companyId;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    private LocalDate established;

    @NotBlank
    @Column(nullable = false)
    private String performanceBenchmark;

    @NotNull
    @Embedded
    private FundPurchaseInfo purchaseInfo;

    @ElementCollection
    private Set<AssetVolume> assetVolumes;

    public void addAssetVolume(AssetVolume volume) {
        GenericAssertions.notNull(volume, "Asset volume cannot be null!");
        if (assetVolumes == null) {
            this.assetVolumes = new TreeSet<>(Comparator.comparing(AssetVolume::getAsOfDate).reversed()
                .thenComparing(AssetVolume::amount)
                .thenComparing(AssetVolume::unit));
        }
        assetVolumes.add(volume);
    }

    public Set<AssetVolume> getAssetVolumes() {
        if (assetVolumes == null || assetVolumes.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(assetVolumes);
    }

    public void managedBy(Long managedBy) {
        GenericAssertions.notNull(managedBy);
        Assert.isTrue(managedBy > 0, "ManagedBy company id cannot be zero or negative");
        if (this.companyId == null) {
            this.companyId = managedBy;
        }
    }


    @Valid
    public static Fund create(@NotBlank String name, @NotBlank String code, @NotNull FundType type, @NotNull @Past LocalDate founded) {
        Assert.hasText(name, "Fund name cannot be empty!");
        Assert.hasText(name, "Fund code cannot be empty!");
        GenericAssertions.notNull(type, "fund type cannot be null!");
        GenericAssertions.isPast(founded, "Fund created date cannot be present or future!");
        return Fund.builder()
                .name(name)
                .code(code)
                .type(type)
                .established(founded)
                .build();
    }
}
