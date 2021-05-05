package com.tng.oss.pfk.domain.common.model;

import com.tng.oss.pfk.domain.common.model.vo.CompanyType;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_name", columnNames = {"name"}),
                @UniqueConstraint(name = "uq_code", columnNames = {"code"})
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class Company extends BaseEntity {

    @EqualsAndHashCode.Include
    @NotBlank
    @Column(nullable = false)
    private String name;

    @EqualsAndHashCode.Include
    @NotBlank
    @Column(nullable = false)
    private String fullName;

    @EqualsAndHashCode.Include
    @NotBlank
    @Length(min = 15, max = 18)
    @Column(length = 18, nullable = false, updatable = false)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private CompanyType type;

    @NotNull
    @Past
    private LocalDate established;

    @Setter(AccessLevel.PUBLIC)
    private String note;

    @Valid
    public static Company create(@NotBlank String name, @NotNull CompanyType type, @NotBlank String code, @NotNull @Past LocalDate established) {
        Assert.hasText(name, "Company name is required!");
        GenericAssertions.notNull(type, "Company type is required");
        Assert.hasText(code, "Company organization code cannot be empty");
        GenericAssertions.isPast(established, "Established date cannot be present or future");
        return Company.builder()
                .name(name)
                .type(type)
                .code(code)
                .established(established)
                .build();
    }
}
