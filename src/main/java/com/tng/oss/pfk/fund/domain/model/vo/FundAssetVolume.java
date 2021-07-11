package com.tng.oss.pfk.fund.domain.model.vo;

import com.tng.oss.pfk.domain.common.model.vo.AssetVolume;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public final class FundAssetVolume implements Comparable<FundAssetVolume> {

    @NotNull
    @Embedded
    private AssetVolume assetVolume;

    //as of deal date
    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private LocalDate reportDate;

    @Override
    public int compareTo(FundAssetVolume o) {
        return reportDate.compareTo(o.reportDate) * -1;
    }
}
