package com.tng.oss.pfk.stocks.presentation;

import com.tng.oss.pfk.infrastructure.web.ListResponsePayload;
import com.tng.oss.pfk.infrastructure.web.ResponsePayload;
import com.tng.oss.pfk.stocks.application.StockInformationService;
import com.tng.oss.pfk.stocks.domain.dto.IndustryDto;
import com.tng.oss.pfk.stocks.domain.vo.IndustryInfoPublisher;
import com.tng.oss.pfk.stocks.presentation.api.IndustryApiData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
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


    @GetMapping("/publishers")
    public ListResponsePayload<IndustryInfoPublisher> industryInfoPublishers() {
        log.info("Finding all industry info publishers");
        return ListResponsePayload.ok(List.of(IndustryInfoPublisher.values()));
    }


    @GetMapping
    public ListResponsePayload<IndustryApiData> all() {
        log.info("Finding all top level industries");
        var industries = service.findTopLevelIndustries().stream()
                .map(IndustryApiData::from)
                .collect(Collectors.toList());
        return ListResponsePayload.ok(industries);
    }

    @GetMapping("/{industryId}")
    public ResponsePayload<IndustryApiData> details(@PathVariable("industryId") @NotNull @Positive Long industryId) {
        log.info("Loading details for industry #{}", industryId);
        var dto = service.findIndustryById(industryId);
        return ResponsePayload.ok(IndustryApiData.from(dto));
    }

    @GetMapping("/{industryId}/children")
    public ListResponsePayload<IndustryApiData> childIndustries(@PathVariable("industryId") @NotNull @Positive Long industryId) {
        log.info("Loading child industries for #{}", industryId);
        var industries = service.findIndustriesByParentId(industryId).stream()
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
