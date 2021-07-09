package com.tng.oss.pfk.domain.common.model.vo;

import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_PRECISION;
import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_SCALE;

@Embeddable
@EqualsAndHashCode
@ToString
@Setter(AccessLevel.NONE)
public final class AssetVolume {
    @NotNull
    @Positive
    @Column(nullable = false, precision = MONEY_PRECISION, scale = MONEY_SCALE )
    private BigDecimal assetVolume;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private AssetVolumeUnit volumeUnit;

    //as of deal date
    @NotNull
    @PastOrPresent
    @Getter
    @Column(nullable = false, updatable = false)
    private LocalDate reportDate;


    AssetVolume(@NotNull @Positive BigDecimal assetVolume, @NotNull AssetVolumeUnit volumeUnit) {
        GenericAssertions.notNull(assetVolume);
        GenericAssertions.notNegative(assetVolume, "Security volume cannot be negative!");
        GenericAssertions.notNull(volumeUnit);
        this.assetVolume = assetVolume;
        this.volumeUnit = volumeUnit;
    }

    @NotNull
    public BigDecimal amount() {
        return this.assetVolume;
    }

    @NotNull
    public AssetVolumeUnit unit() {
        return this.volumeUnit;
    }

    public static AssetVolume ofBillion(@NotNull @Positive BigDecimal volume) {
        return new AssetVolume(volume, AssetVolumeUnit.BILLION);
    }
}
