package com.tng.oss.pfk.stocks.presentation.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public final class IndustryApiData {
    @Positive
    private Long id;

    @NotBlank
    @JsonProperty(required = true)
    private String code;

    @NotBlank
    @JsonProperty(required = true)
    private String name;


    @Positive
    private Long parentId;
    private String parentCode;
    private String parentName;
    private String expandedFullName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public boolean hasParent() {
        return parentId != null;
    }

    public static IndustryApiData from(IndustryDto dto) {
        IndustryApiData apiData = new IndustryApiData();
        apiData.setId(dto.getId());
        apiData.setCode(dto.getCode());
        apiData.setName(dto.getName());
        if (dto.getParent() != null) {
            apiData.setParentId(dto.getParent().getId());
            apiData.setParentCode(dto.getParent().getCode());
            apiData.setParentName(dto.getParent().getName());
            apiData.setExpandedFullName(dto.getExpandedName());
        }
        return apiData;
    }
}
