package com.tng.oss.pfk.stocks.domain.model;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import com.tng.oss.pfk.stocks.domain.dto.StockDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_stock_code", columnNames = {"code"})
        },
        indexes = {
                @Index(name = "idx_stock_code", columnList = "code")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Stock extends BaseEntity {
    @NotBlank
    @Column(nullable = false, updatable = false)
    private String code;

    @Size(max = 64)
    @Column(nullable = false, length = 64)
    private String name;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Long industryId;

    private String description;

    public static Stock create(@NotNull @Valid StockDto dto) {
        GenericAssertions.hasText(dto.getCode(),"Stock code cannot be empty!");
        GenericAssertions.hasText(dto.getName(),"Stock name cannot be empty");
        GenericAssertions.isPositive(dto.getIndustryId(), "Industry ID is invalid");
        return new Stock(dto.getCode(), dto.getName(), dto.getIndustryId(), dto.getDescription());
    }
}
