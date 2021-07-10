package com.tng.oss.pfk.stocks.domain.dto;

import com.tng.oss.pfk.stocks.domain.model.Industry;
import com.tng.oss.pfk.stocks.domain.vo.IndustryInfoPublisher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@Data
public final class IndustryDto {
    private Long id;

    private IndustryInfoPublisher publisher;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private IndustryDto parent;
    private String description;

    @Setter(value = AccessLevel.NONE)
    private String expandedName;

    private void loadExpandedName() {
        if (StringUtils.hasText(expandedName)) {
            return;
        }
        List<String> names = new ArrayList<>(5);
        collectAncestorName(parent, names);
        Collections.reverse(names);
        this.expandedName = String.join("-", names) + "-" + this.name;
    }

    private void collectAncestorName(IndustryDto parentDto, List<String> names) {
        if (parentDto == null) {
            return;
        }
        names.add(parentDto.getName());
        collectAncestorName(parentDto.getParent(), names);
    }

    public static IndustryDto from(@NotNull Industry industry) {
        IndustryDto dto = IndustryDto.builder()
                .id(industry.getId())
                .publisher(industry.getPublisher())
                .code(industry.getCode())
                .name(industry.getName())
                .description(industry.getDescription())
                .build();
        if (industry.getParent() != null) {
            dto.parent = IndustryDto.from(industry.getParent());
        }
        dto.loadExpandedName();
        return dto;
    }
}
