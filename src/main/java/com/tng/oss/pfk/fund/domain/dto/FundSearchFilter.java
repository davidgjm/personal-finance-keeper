package com.tng.oss.pfk.fund.domain.dto;

import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import lombok.Data;

import java.time.Period;

@Data
public final class FundSearchFilter {
    private FundType type;
    private Period age;


    public boolean isEmpty() {
        return type == null
                && age == null
                ;
    }
}
