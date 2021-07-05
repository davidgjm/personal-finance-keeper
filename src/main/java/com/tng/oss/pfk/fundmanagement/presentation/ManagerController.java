package com.tng.oss.pfk.fundmanagement.presentation;

import com.tng.oss.pfk.fundmanagement.application.FundManagementService;
import com.tng.oss.pfk.fundmanagement.presentation.api.ManagerApiData;
import com.tng.oss.pfk.fundmanagement.presentation.api.ManagerCommentApiData;
import com.tng.oss.pfk.infrastructure.web.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.stream.Collectors;

import static com.tng.oss.pfk.infrastructure.web.StandardQueryParameters.PAGINATION_FIRST_PAGE;

@Slf4j
@RestController
@RequestMapping("/admin/fm/managers")
@Validated
public class ManagerController {
    private final FundManagementService fms;

    public ManagerController(FundManagementService fms) {
        this.fms = fms;
    }

    @PostMapping
    public ResponsePayload<ManagerApiData> create(@NotNull @RequestBody ManagerApiData apiData) {
        log.info("Attempting to create new fund manager with data. {}", apiData);
        var dto = fms.create(apiData.asDto());
        return ResponsePayload.ok(ManagerApiData.from(dto));
    }

    @PutMapping("/{id}")
    public ResponsePayload<ManagerApiData> update(@PathVariable("id") @NotNull @Positive Long id, @NotNull @RequestBody ManagerApiData apiData) {
        log.info("Attempting to update fund manager with data. {}", apiData);
        validateIdInPathAndRequest(id, apiData);
        var dto = fms.update(apiData.asDto());
        return ResponsePayload.ok(ManagerApiData.from(dto));
    }

    @GetMapping
    public PaginatedResponsePayload<ManagerApiData> all(@RequestParam(defaultValue = PAGINATION_FIRST_PAGE + "") int pageNumber, @RequestParam(defaultValue = StandardQueryParameters.PAGINATION_DEFAULT_SIZE + "") int pageSize) {
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        log.info("Attempting to load fund managers with page request: {}", pageRequest);
        return PaginatedResponsePayload.ok(fms.allManagers(pageRequest).map(ManagerApiData::from));
    }

    @GetMapping("/{id}")
    public ResponsePayload<ManagerApiData> getManagerDetails(@PathVariable("id") @NotNull @Positive Long id) {
        log.info("Attempting to load details for manager id: {}", id);
        var dto = fms.manager(id);
        return ResponsePayload.ok(ManagerApiData.from(dto));
    }


    @GetMapping("/{id}/comments")
    public ListResponsePayload<ManagerCommentApiData> getManagerComments(@PathVariable("id") @NotNull @Positive Long id) {
        log.info("Attempting to load comments for manager id: {}", id);
        var comments = fms.findComments(id).stream()
                .map(ManagerCommentApiData::from)
                .collect(Collectors.toList());
        return ListResponsePayload.ok(comments);
    }

    @PostMapping("/{id}/comments")
    public ResponsePayload<ManagerCommentApiData> addComments(@PathVariable("id") @NotNull @Positive Long id, @RequestBody ManagerCommentApiData apiData) {
        log.info("Attempting to add comment for manager id: {}. Comment details: {}", id, apiData);
        var commentDto = fms.commentOnFundManager(apiData.getComment(), id);
        return ResponsePayload.ok(ManagerCommentApiData.from(commentDto));
    }


    private void validateIdInPathAndRequest(Long idInPath, ManagerApiData apiData) {
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
