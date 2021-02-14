package com.tng.oss.pfk.domain.fund.model;

import com.tng.oss.pfk.domain.fund.model.vo.FundType;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_fund_name", columnNames = {"name"}),
                @UniqueConstraint(name = "uq_fund_code", columnNames = {"code"}),
        },
        indexes = {
                @Index(name = "idx_fund_code", columnList = "code")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@Builder
public class Fund extends BaseEntity {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Setter(AccessLevel.MODULE)
    @EqualsAndHashCode.Include
    @NotBlank
    @Pattern(regexp = "\\d{6}")
    @Column(nullable = false, updatable = false, length = 6)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FundType type;

    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    private Long managedBy;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    private LocalDate founded;

    public void managedBy(Long managedBy) {
        GenericAssertions.notNull(managedBy);
        Assert.isTrue(managedBy > 0, "ManagedBy company id cannot be zero or negative");
        if (this.managedBy == null) {
            this.managedBy = managedBy;
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
                .founded(founded)
                .build();
    }
}
