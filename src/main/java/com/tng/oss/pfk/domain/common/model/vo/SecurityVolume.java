package com.tng.oss.pfk.domain.common.model.vo;

import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_PRECISION;
import static com.tng.oss.pfk.infrastructure.MoneyConstants.MONEY_SCALE;

@Embeddable
@EqualsAndHashCode
@ToString
@Setter(AccessLevel.NONE)
public final class SecurityVolume {
    @NotNull
    @Positive
    @Column(name = "volume", nullable = false, precision = MONEY_PRECISION, scale = MONEY_SCALE )
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private VolumeUnit volumeUnit;

    SecurityVolume(@NotNull @Positive BigDecimal amount, @NotNull VolumeUnit volumeUnit) {
        GenericAssertions.notNull(amount);
        GenericAssertions.notNegative(amount, "Security volume cannot be negative!");
        GenericAssertions.notNull(volumeUnit);
        this.amount = amount;
        this.volumeUnit = volumeUnit;
    }

    @NotNull
    public BigDecimal amount() {
        return this.amount;
    }

    @NotNull
    public VolumeUnit unit() {
        return this.volumeUnit;
    }

    public static SecurityVolume ofBillion(@NotNull @Positive BigDecimal volume) {
        return new SecurityVolume(volume, VolumeUnit.BILLION);
    }
}
