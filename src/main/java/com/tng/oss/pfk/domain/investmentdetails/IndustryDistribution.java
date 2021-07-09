package com.tng.oss.pfk.domain.investmentdetails;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.persistence.GenericPeriodicInfoEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_fund_industry_dist_date", columnNames = {"fundId", "recordDate"}),
        },
        indexes = {
                @Index(name = "idx_report_date_industry_dist", columnList = "recordDate")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@Builder
public final class IndustryDistribution extends BaseEntity implements GenericPeriodicInfoEntity {
    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    private Long fundId;

    @NotNull
    @Past
    @Column(nullable = false, updatable = false)
    @Setter(value = AccessLevel.PROTECTED)
    private LocalDate recordDate;



    @NotEmpty
    @ElementCollection
    @CollectionTable(
            name = "INDUSTRY_DISTRIBUTION_ITEMS",
            joinColumns = {@JoinColumn(name = "groupId")},
            uniqueConstraints = @UniqueConstraint(name = "uq_group_industry", columnNames = {"groupId", "industryId"})
    )
    private Set<IndustryDistributionItem> distributionItems;

    public void addHoldingItem(@NotNull IndustryDistributionItem item) {
        GenericAssertions.notNull(item, "Fund industry distribution item cannot be null!");
        if (distributionItems == null) {
            this.distributionItems = new TreeSet<IndustryDistributionItem>(Comparator.comparing(IndustryDistributionItem::getNetAssetValueRatio).reversed())
            ;
        }
        distributionItems.add(item);
    }


    public Set<IndustryDistributionItem> getDistributionItems() {
        if (distributionItems == null || distributionItems.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(distributionItems);
    }

    @PostLoad
    private void loadParent() {
        if (!distributionItems.isEmpty()) {
            distributionItems.forEach(i -> i.setParentId(this.getId()));
        }
    }
}
