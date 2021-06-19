package com.tng.oss.pfk.fundmanagement.domain.dtos;

import com.tng.oss.pfk.fundmanagement.domain.FundManagerNote;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;

@Data
@Builder
@Valid
public class FundManagerComment {
    @NotBlank
    private String comment;
    
    @NotNull
    @Past
    private Instant commentedOn;
    private String commentedBy;

    public static FundManagerComment from(FundManagerNote note) {
        return FundManagerComment.builder()
                .comment(note.getComment())
                .commentedOn(note.getCommentedOn())
                .commentedBy(note.getCommentedBy())
                .build();
    }
}
