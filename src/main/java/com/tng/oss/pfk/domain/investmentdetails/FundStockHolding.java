package com.tng.oss.pfk.domain.investmentdetails;

import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
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
                @UniqueConstraint(name = "uq_fund_holdings_fund_date", columnNames = {"fundId", "recordDate"}),
        },
        indexes = {
                @Index(name = "idx_record_date", columnList = "recordDate")
        }
)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor
public class FundStockHolding extends BaseEntity{
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
            name = "FUND_HOLDING_ITEMS",
            joinColumns = {@JoinColumn(name = "groupId")},
            uniqueConstraints = @UniqueConstraint(name = "uq_group_stock", columnNames = {"groupId", "stockId"})
    )
    private Set<FundHoldingItem> stockHoldingItems;

    public void addStockHoldingItem(@NotNull FundHoldingItem holdingItem) {
        GenericAssertions.notNull(holdingItem, "Fund holding item cannot be null!");
        if (stockHoldingItems == null) {
            this.stockHoldingItems = new TreeSet<FundHoldingItem>(Comparator.comparing(FundHoldingItem::getNetAssetValueRatio).reversed())
                    ;
        }
        stockHoldingItems.add(holdingItem);
    }


    public Set<FundHoldingItem> getStockHoldingItems() {
        if (stockHoldingItems == null || stockHoldingItems.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(stockHoldingItems);
    }

    @PostLoad
    private void loadParent() {
        if (!stockHoldingItems.isEmpty()) {
            stockHoldingItems.forEach(i -> i.setParentId(this.getId()));
        }
    }
}
