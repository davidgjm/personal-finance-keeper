package com.tng.oss.pfk.fundmanagement.presentation.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public final class ManagerCommentApiData {
    @JsonProperty(required = true)
    private String comment;

}
