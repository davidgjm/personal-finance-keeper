package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.domain.common.model.vo.AssetVolume;
import com.tng.oss.pfk.infrastructure.core.persistence.AuditableEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_PRECISION;
import static com.tng.oss.pfk.infrastructure.RateConstants.RETURN_RATE_SCALE;

@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.PACKAGE)
public final class FundManager extends AuditableEntity {
    @EqualsAndHashCode.Include
    @NotBlank
    @Column(nullable = false, updatable = false, length = 10)
    private String name;

    @NotNull
    @Past
    @Column(nullable = false)
    private LocalDate careerStarted;

    @PositiveOrZero
    private Long companyId;

    private AssetVolume totalManagedAsset;

    @NotNull
    @Column(nullable = false, precision = RETURN_RATE_PRECISION, scale = RETURN_RATE_SCALE)
    private BigDecimal annualReturnRate;

    @NotNull
    @Column(nullable = false, precision = RETURN_RATE_PRECISION, scale = RETURN_RATE_SCALE)
    private BigDecimal bestReturnRate;

    @Column(length = 1024)
    private String introduction;

    private String investingStyle;

    @Setter(AccessLevel.NONE)
    @ElementCollection
    private List<FundManagerNote> comments;

    public void addComment(@NotNull FundManagerNote comment) {
        GenericAssertions.notNull(comment, "Comment cannot be null!");
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
    }

    public List<FundManagerNote> getComments() {
        if (this.comments == null || this.comments.isEmpty()) {
            return Collections.emptyList();
        }
        this.comments.sort(FundManagerNote::compareTo);
        return Collections.unmodifiableList(this.comments);
    }
}
