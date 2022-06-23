package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.model.FundManager;
import com.tng.oss.pfk.infrastructure.core.GenericDtoMapper;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import org.springframework.stereotype.Component;

@Component
public class FundManagerDtoMapper implements GenericDtoMapper<FundManager, FundManagerDto> {
    @Override
    public FundManager asModel(FundManagerDto dto) {
        FundManager manager = new FundManager();
        manager.setName(dto.getName());
        manager.setCareerStarted(dto.getCareerStarted());
        manager.setCompanyId(dto.getCompanyId());
        manager.setTotalManagedAsset(dto.getPresentTotalManagedAsset());
        manager.setAnnualReturnRate(dto.getAnnualReturnRate());
        manager.setBestReturnRate(dto.getBestReturnRate());
        manager.setIntroduction(dto.getIntroduction());
        manager.setInvestingStyle(dto.getInvestingStyle());
        return manager;
    }

    @Override
    public FundManagerDto asDto(FundManager model) {
        GenericAssertions.notNull(model);
        return FundManagerDto.builder()
                .name(model.getName())
                .careerStarted(model.getCareerStarted())
                .companyId(model.getCompanyId())
                .presentTotalManagedAsset(model.getTotalManagedAsset())
                .annualReturnRate(model.getAnnualReturnRate())
                .bestReturnRate(model.getBestReturnRate())
                .introduction(model.getIntroduction())
                .investingStyle(model.getInvestingStyle())
                .created(model.getCreated())
                .updated(model.getLastUpdated())
                .build();
    }
}
