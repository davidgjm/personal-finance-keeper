package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerComment;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import com.tng.oss.pfk.infrastructure.core.GenericDtoMapper;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FundManagerDtoMapper implements GenericDtoMapper<FundManager, FundManagerDto> {
    @Override
    public FundManager asModel(FundManagerDto dto) {
        FundManager manager = new FundManager();
        manager.setName(dto.getFullName());
        manager.setCareerStarted(dto.getCareerStarted());
        manager.setCompanyId(dto.getCompanyId());
        manager.setTotalManagedAsset(dto.getPresentTotalManagedAsset());
        manager.setAnnualReturnRate(dto.getAnnualReturnRate());
        manager.setBestReturnRate(dto.getBestReturnRate());
        manager.setIntroduction(dto.getIntroduction());
        manager.setInvestingStyle(dto.getInvestingStyle());
        dto.getComments().forEach(comment -> manager.addComment(FundManagerNote.of(comment)));
        return manager;
    }

    @Override
    public FundManagerDto asDto(FundManager model) {
        GenericAssertions.notNull(model);
        return FundManagerDto.builder()
                .fullName(model.getName())
                .careerStarted(model.getCareerStarted())
                .companyId(model.getCompanyId())
                .presentTotalManagedAsset(model.getTotalManagedAsset())
                .annualReturnRate(model.getAnnualReturnRate())
                .bestReturnRate(model.getBestReturnRate())
                .introduction(model.getIntroduction())
                .investingStyle(model.getInvestingStyle())
                .comments(model.getComments().stream().map(FundManagerComment::from).collect(Collectors.toList()))
                .build();
    }
}
