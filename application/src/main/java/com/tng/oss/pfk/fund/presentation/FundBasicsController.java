package com.tng.oss.pfk.fund.presentation;

import com.tng.oss.pfk.fund.application.FundApplicationService;
import com.tng.oss.pfk.fund.domain.dto.FundSearchFilter;
import com.tng.oss.pfk.fund.domain.model.vo.FundType;
import com.tng.oss.pfk.fund.presentation.api.FundBasicsInfoApiData;
import com.tng.oss.pfk.infrastructure.web.ListResponsePayload;
import com.tng.oss.pfk.infrastructure.web.PaginatedResponsePayload;
import com.tng.oss.pfk.infrastructure.web.ResponsePayload;
import com.tng.oss.pfk.infrastructure.web.StandardQueryParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;

import static com.tng.oss.pfk.infrastructure.web.StandardQueryParameters.PAGINATION_FIRST_PAGE;

@Slf4j
@RestController
@RequestMapping("/funds")
@Validated
public class FundBasicsController {
    private final FundApplicationService applicationService;

    public FundBasicsController(FundApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/types")
    public ListResponsePayload<FundType> types() {
        return ListResponsePayload.ok(List.of(FundType.values()));
    }

    @GetMapping("/basics")
    public PaginatedResponsePayload<FundBasicsInfoApiData> all(@RequestParam(defaultValue = PAGINATION_FIRST_PAGE + "") int pageNumber,
                                                               @RequestParam(defaultValue = StandardQueryParameters.PAGINATION_DEFAULT_SIZE + "") int pageSize,
                                                               @Valid FundSearchFilter filterRequest) {
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        log.info("Attempting to load all fund basic information items with page request: {}", pageRequest);
        log.info("Provided filters via request parameters. {}", filterRequest);

        var responseData = applicationService.allBasicItems(filterRequest, pageRequest).map(FundBasicsInfoApiData::from);
        return PaginatedResponsePayload.ok(responseData);
    }


    @GetMapping("/basics/{code}")
    public ResponsePayload<FundBasicsInfoApiData> detailsByCode(@PathVariable("code") @NotBlank @Pattern(regexp = "\\d{6}", message = "Invalid fund code!") String code) {
        log.info("Loading fund details by code {}", code);
        var result = applicationService.withCode(code);
        return ResponsePayload.ok(FundBasicsInfoApiData.from(result));
    }

    @PostMapping("/basics")
    public ResponsePayload<FundBasicsInfoApiData> create(@RequestBody @NotNull @Valid FundBasicsInfoApiData requestData) {
        log.info("Attempting to create new fund with request data. {}", requestData);
        var result = applicationService.newFund(requestData.asDto());
        return ResponsePayload.ok(FundBasicsInfoApiData.from(result));
    }
}
