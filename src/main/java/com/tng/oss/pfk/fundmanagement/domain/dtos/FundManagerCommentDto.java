package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.model.FundManagerComment;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.Instant;

@Data
@Builder
@Valid
public class FundManagerCommentDto {
    @Positive
    private Long managerId;

    @NotBlank
    private String comment;
    
    @NotNull
    @Past
    private Instant commentedOn;
    private String commentedBy;

    public static FundManagerCommentDto from(FundManagerComment entity) {
        return FundManagerCommentDto.builder()
                .managerId(entity.getManagerId())
                .comment(entity.getComment())
                .commentedOn(entity.getCommentedOn())
                .commentedBy(entity.getCommentedBy())
                .build();
    }
}
