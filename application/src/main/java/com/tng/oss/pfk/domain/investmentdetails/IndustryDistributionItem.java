package com.tng.oss.pfk.domain.investmentdetails;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@Setter(AccessLevel.PRIVATE)
public class IndustryDistributionItem {
    @NotNull
    @Positive
    @Transient
    @Setter(AccessLevel.PACKAGE)
    private Long parentId;

    @NotNull
    @Positive
    private Long industryId;


    @NotNull
    @PositiveOrZero
    private BigDecimal netAssetValueRatio;

}
