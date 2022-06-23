package com.tng.oss.pfk.domain.common.model.vo;

import com.tng.oss.pfk.infrastructure.VolumeUnit;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_PRECISION;
import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_SCALE;


@Embeddable
@Data
@Setter(AccessLevel.NONE)
public final class FlexibleLargeVolume {
    @NotNull
    @Positive
    @Column(nullable = false, precision = MONEY_PRECISION, scale = MONEY_SCALE)
    private BigDecimal volume;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private VolumeUnit volumeUnit;


    FlexibleLargeVolume(@NotNull @Positive BigDecimal volume, @NotNull VolumeUnit volumeUnit) {
        GenericAssertions.notNull(volume);
        GenericAssertions.notNegative(volume, "Security volume cannot be negative!");
        GenericAssertions.notNull(volumeUnit);
        this.volume = volume;
        this.volumeUnit = volumeUnit;
    }


    @Transient
    public BigDecimal getExpandedAmount() {
        switch (volumeUnit) {
            case MILLION:
                return volume.multiply(BigDecimal.valueOf(1000000));
            case HUNDRED_MILLION:
                return volume.multiply(BigDecimal.valueOf(100000000));
            case BILLION:
                return volume.multiply(BigDecimal.valueOf(1000000000));
        }
        return volume;
    }


    public static FlexibleLargeVolume ofBillion(@NotNull @Positive BigDecimal volume) {
        return new FlexibleLargeVolume(volume, VolumeUnit.BILLION);
    }
}
