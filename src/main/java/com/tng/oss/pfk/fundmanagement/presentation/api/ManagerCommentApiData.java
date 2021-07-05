package com.tng.oss.pfk.fundmanagement.presentation.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerCommentDto;
import lombok.Data;

import java.time.Instant;

@Data
public final class ManagerCommentApiData {
    private Long managerId;

    @JsonProperty(required = true)
    private String comment;

    private Instant commentedOn;

    private String commentedBy;

    public static ManagerCommentApiData from(FundManagerCommentDto commentDto) {
        var apiData = new ManagerCommentApiData();
        apiData.setManagerId(commentDto.getManagerId());
        apiData.setComment(commentDto.getComment());
        apiData.setCommentedOn(commentDto.getCommentedOn());
        apiData.setCommentedBy(commentDto.getCommentedBy());
        return apiData;
    }
}
