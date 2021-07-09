package com.tng.oss.pfk.stocks.presentation;

import com.tng.oss.pfk.infrastructure.web.ListResponsePayload;
import com.tng.oss.pfk.infrastructure.web.ResponsePayload;
import com.tng.oss.pfk.stocks.application.StockInformationService;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/admin/fm/industries")
@Validated
public class IndustryController {
    private final StockInformationService service;

    public IndustryController(StockInformationService service) {
        this.service = service;
    }

    @GetMapping
    public ListResponsePayload<IndustryApiData> all() {
        log.info("Finding all top level industries");
        var industries = service.findTopLevelIndustries().stream()
                .map(IndustryApiData::from)
                .collect(Collectors.toList());
        return ListResponsePayload.ok(industries);
    }

    @PostMapping
    public ResponsePayload<IndustryApiData> create(@RequestBody IndustryApiData requestBody) {
        log.info("Attempting create new industry with request data. {}", requestBody);
        IndustryDto responseData = service.newIndustry(requestBody.getCode(), requestBody.getName(), requestBody.getParentId());
        return ResponsePayload.ok(IndustryApiData.from(responseData));
    }
}
