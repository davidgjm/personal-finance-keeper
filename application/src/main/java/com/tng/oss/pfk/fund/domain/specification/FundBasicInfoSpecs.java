package com.tng.oss.pfk.fund.domain.specification;

import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.model.FundBasicInfo;
import com.tng.oss.pfk.fund.domain.model.FundBasicInfo_;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.Period;

@Validated
public class FundBasicInfoSpecs {
    public static Specification<FundBasicInfo> olderThan(Period age) {
        Assert.notNull(age, "Age cannot be null!");
        return (root, query, builder) -> {
            LocalDate date = LocalDate.now().minus(age);
            return builder.lessThanOrEqualTo(root.get(FundBasicInfo_.established), date);
        };
    }

    public static Specification<FundBasicInfo> ofType(FundType type) {
        Assert.notNull(type, "type cannot be null!");
        return (root, query, builder) -> builder.equal(root.get(FundBasicInfo_.type), type);
    }

    public static Specification<FundBasicInfo> ofCompany(@NotNull @Positive Long companyId) {
        GenericAssertions.isPositive(companyId,"CompanyId cannot be zero or negative!");
        return (root, query, builder) -> builder.equal(root.get(FundBasicInfo_.companyId), companyId);
    }

    public static Specification<FundBasicInfo> composite(FundSearchFilter searchFilter) {
        Assert.notNull(searchFilter, "search filter cannot be null!");
        var type = searchFilter.getType();
        var age = searchFilter.getAge();
        if (type != null && age != null) {
            return ofType(type).and(olderThan(age));
        } else if (type !=null){
            return ofType(type);
        }else {
            return olderThan(age);
        }
    }
}
