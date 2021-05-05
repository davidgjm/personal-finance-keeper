package com.tng.oss.pfk.domain.fund.model.vo;

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
    private LocalDate asOfDate;

    @Override
    public int compareTo(FundAssetVolume o) {
        return asOfDate.compareTo(o.asOfDate) * -1;
    }
}
