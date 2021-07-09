package com.tng.oss.pfk.domain.fund.model;

import com.tng.oss.pfk.domain.fund.dto.FundDto;
import com.tng.oss.pfk.domain.fund.model.vo.FundPurchaseInfo;
import com.tng.oss.pfk.domain.fund.model.vo.FundType;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


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
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Validated
public final class FundBasicInfo extends BaseEntity {

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @NotBlank
    @Pattern(regexp = "\\d{6}")
    @Column(nullable = false, updatable = false, length = 6)
    private String code;


    @NotBlank
    @Setter(AccessLevel.NONE)
    @Column(nullable = false,length = 20)
    private String name;

    @NotBlank
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    private String fullName;


    @NotNull
    @Setter(AccessLevel.NONE)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FundType type;

    @NotNull
    @Positive
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private Long companyId;

    @NotNull
    @Past
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private LocalDate established;

    @NotBlank
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private String performanceBenchmark;

    @NotNull
    @Embedded
    private FundPurchaseInfo purchaseInfo;

    FundBasicInfo(Long companyId, String code, String name, FundType type, String fullName, LocalDate established, String performanceBenchmark) {
        GenericAssertions.isPositive(companyId, "companyId is required");
        GenericAssertions.hasText(code,"fund code cannot be empty!");
        GenericAssertions.hasText(name,"fund name cannot be empty!");
        GenericAssertions.notNull(type, "fund type cannot be null");
        GenericAssertions.hasText(fullName,"fund fullName cannot be empty!");
        GenericAssertions.isPast(established, "Fund established date not valid");
        GenericAssertions.hasText(performanceBenchmark,"fund performanceBenchmark cannot be empty!");
        this.code = code;
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        this.companyId = companyId;
        this.established = established;
        this.performanceBenchmark = performanceBenchmark;
    }

    public static FundBasicInfo newFund(@NotNull @Valid FundDto dto) {
        FundBasicInfo fund = new FundBasicInfo(dto.getCompanyId(), dto.getCode(),dto.getName(),dto.getType(), dto.getFullName(), dto.getEstablished(), dto.getPerformanceBenchmark());
        fund.setPurchaseInfo(dto.getPurchaseInfo());
        return fund;
    }
}
