package com.tng.oss.pfk.stocks.presentation;

import com.tng.oss.pfk.infrastructure.web.PaginatedResponsePayload;
import com.tng.oss.pfk.infrastructure.web.ResponsePayload;
import com.tng.oss.pfk.infrastructure.web.StandardQueryParameters;
import com.tng.oss.pfk.stocks.application.StockInformationService;
import com.tng.oss.pfk.stocks.presentation.api.StockApiData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.tng.oss.pfk.infrastructure.web.StandardQueryParameters.PAGINATION_FIRST_PAGE;

@Slf4j
@RestController
@Validated
@RequestMapping("/admin/fm/stocks")
public class StockController {
    private final StockInformationService service;

    public StockController(StockInformationService service) {
        this.service = service;
    }

    @GetMapping
    public PaginatedResponsePayload<StockApiData> all(@RequestParam(defaultValue = PAGINATION_FIRST_PAGE+"") int pageNumber,
                                                      @RequestParam(defaultValue = StandardQueryParameters.PAGINATION_DEFAULT_SIZE +"") int pageSize) {
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        log.info("Attempting to load stocks with page request: {}", pageRequest);
        var responseData = service.findAllStocks(pageRequest)
                .map(StockApiData::from);
        return PaginatedResponsePayload.ok(responseData);
    }

    @PostMapping
    public ResponsePayload<StockApiData> createStock(@NotNull @Valid @RequestBody StockApiData requestData) {
        log.info("Attempting to create new stock with request data: {}", requestData);
        var dto = service.newStock(requestData.getCode(), requestData.getName(), requestData.getIndustryId(), requestData.getDescription());
        return ResponsePayload.ok(StockApiData.from(dto));
    }
}
