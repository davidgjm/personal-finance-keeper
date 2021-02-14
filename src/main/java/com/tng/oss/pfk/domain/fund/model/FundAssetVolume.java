package com.tng.oss.pfk.domain.fund.model;

import com.tng.oss.pfk.domain.common.model.vo.SecurityVolume;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(name = "uq_fund_vol", columnNames = {"fundCode", "recordDate"})
)
public final class FundAssetVolume extends BaseEntity {

    @NotNull
    @Positive
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private String fundCode;

    //as of deal date
    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    private LocalDate recordDate;

    @NotNull
    @Embedded
    private SecurityVolume assetVolume;

}
