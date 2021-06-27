package com.tng.oss.pfk.fundmanagement.presentation;

import com.tng.oss.pfk.fundmanagement.application.FundManagementService;
import com.tng.oss.pfk.fundmanagement.presentation.api.CompanyApiData;
import com.tng.oss.pfk.infrastructure.web.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static com.tng.oss.pfk.infrastructure.web.StandardQueryParameters.PAGINATION_FIRST_PAGE;

@Slf4j
@RestController
@RequestMapping("/admin/fm/companies")
@Validated
public class CompanyController {
    private final FundManagementService fms;

    public CompanyController(FundManagementService fms) {
        this.fms = fms;
    }

    @GetMapping
    public PaginatedResponsePayload<CompanyApiData> all(@RequestParam(defaultValue = PAGINATION_FIRST_PAGE+"") int pageNumber, @RequestParam(defaultValue = StandardQueryParameters.PAGINATION_DEFAULT_SIZE +"") int pageSize) {
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        log.info("Attempting to load companies with page request: {}", pageRequest);
        return PaginatedResponsePayload.ok(fms.findAllCompanies(pageRequest).map(CompanyApiData::from));
    }

    @PostMapping
    public ResponsePayload<CompanyApiData> createCompany(@RequestBody @NotNull CompanyApiData requestData) {
        log.info("Attempting to create fund company with request data: {}", requestData);
        var dto = fms.create(requestData.asDto());
        return ResponsePayload.ok(CompanyApiData.from(dto));
    }

    @PutMapping("/{id}")
    public ResponsePayload<CompanyApiData> update(@PathVariable("id") @NotNull @Positive Long id, @RequestBody @NotNull CompanyApiData requestData) {
        log.info("Attempting to update fund company #{} with request data: {}", id, requestData);
        var dto = fms.update(requestData.asDto());
        validIdInPathAndRequest(id, requestData);
        return ResponsePayload.ok(CompanyApiData.from(dto));
    }


    private void validIdInPathAndRequest(Long idInPath, CompanyApiData apiData) {
        log.debug("Checking the ID value in path variable against the value in request body! Path variable={}, Id in request: {}", idInPath, apiData.getId());
        var idInData = apiData.getId();
        if (idInData == null) {
            log.error("Company Id is missing in request data");
            throw new WebApiException(GeneralWebError.ID_MISSING);
        }
        if (!idInPath.equals(idInData)) {
            log.error("ID mismatch. Id in Path: {}, id in data: {}", idInPath, idInData);
            throw new WebApiException(GeneralWebError.ID_MISMATCH_IN_PATH_PAYLOAD);
        }
    }
}
