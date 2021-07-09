package com.tng.oss.pfk.stocks.domain.model;

import com.tng.oss.pfk.stocks.StockInfoException;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Comparator;

import static com.tng.oss.pfk.stocks.StockInfoError.INDUSTRY_SELF_AS_PARENT;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_code", columnNames = {"code"})
        }
)
@NoArgsConstructor
public class Industry extends BaseEntity implements Comparator<Industry>, Comparable<Industry> {

    @EqualsAndHashCode.Include
    @NotBlank
    @Size(min = 1, max = 16)
    @Column(nullable = false, updatable = false, length = 20)
    private String code;

    @NotBlank
    @Column(nullable = false, updatable = false, length = 128)
    private String name;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Industry parent;

    public Industry(String code, String name, Industry parent) {
        GenericAssertions.hasText(code, "Industry code cannot be empty!");
        GenericAssertions.hasText(name, "Industry name cannot be empty!");
        if (this.equals(parent)) {
            throw new StockInfoException(INDUSTRY_SELF_AS_PARENT);
        }
        this.code = code;
        this.name = name;
        this.parent = parent;
    }

    @Override
    public int compareTo(Industry o) {
        return this.code.compareTo(o.code);
    }

    @Override
    public int compare(Industry o1, Industry o2) {
        return o1.getCode().compareTo(o2.getCode());
    }

    public static Industry create(@NotBlank String code, @NotBlank String name, Industry parent) {
        return new Industry(code, name, parent);
    }

    public static Industry create(@NotBlank String code, @NotBlank String name) {
        return create(code, name, null);
    }
}
