package com.tng.oss.pfk.stocks.presentation.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.vo.IndustryInfoPublisher;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public final class IndustryApiData {
    @Positive
    private Long id;

    @NotNull
    @JsonProperty(required = true)
    private IndustryInfoPublisher publisher;

    @NotBlank
    @JsonProperty(required = true)
    private String code;

    @NotBlank
    @JsonProperty(required = true)
    private String name;

    private String description;

    @Positive
    private Long parentId;
    private String parentName;
    private String expandedFullName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public boolean isRootLevel() {
        return parentId == null;
    }

    public static IndustryApiData from(IndustryDto dto) {
        IndustryApiData apiData = new IndustryApiData();
        apiData.setId(dto.getId());
        apiData.setCode(dto.getCode());
        apiData.setName(dto.getName());
        apiData.setDescription(dto.getDescription());

        if (dto.getParent() != null) {
            apiData.setParentId(dto.getParent().getId());
            apiData.setParentName(dto.getParent().getName());
            apiData.setExpandedFullName(dto.getExpandedName());
        }
        return apiData;
    }
}
