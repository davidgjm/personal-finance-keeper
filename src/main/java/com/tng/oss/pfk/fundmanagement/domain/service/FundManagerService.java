package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

public interface FundManagerService {
    /**
     * Finds all fund managers in the system
     * @param pageRequest Pagination data
     * @return Paged data containing managers
     */
    Page<FundManagerDto> all(@NotNull PageRequest pageRequest);

    /**
     * Finds all fund managers in a company
     *
     * @param companyId Company Id
     * @return
     */
    Page<FundManagerDto> all(@NotNull @Positive Long companyId, PageRequest pageRequest);

    /**
     * Find all managers with the provided name.
     * <b>Note that 2 different managers may have the same name.</b>
     * @param name
     * @return
     */
    List<FundManagerDto> of(@NotBlank String name);

    Optional<FundManagerDto> of(@NotNull @Positive Long managerId);

    /**
     * Create a fund manager record.
     * <p>
     *     The following fields will be updated for an <i>update</i> operation
     *     <ul>
     *         <li>companyId</li>
     *         <li>totalManagedAsset</li>
     *         <li>annualReturnRate</li>
     *         <li>bestReturnRate</li>
     *         <li>introduction</li>
     *         <li>investingStyle</li>
     *         <li></li>
     *     </ul>
     *     <i>comments</i> will be operated in a different method.
     * </p>
     * @param managerDto manager DTO to be acted on
     * @return
     */
    FundManagerDto create(@NotNull @Valid FundManagerDto managerDto);

    /**
     * Updates a fund manager record.
     * <p>
     *     The following fields will be updated for an <i>update</i> operation
     *     <ul>
     *         <li>companyId</li>
     *         <li>totalManagedAsset</li>
     *         <li>annualReturnRate</li>
     *         <li>bestReturnRate</li>
     *         <li>introduction</li>
     *         <li>investingStyle</li>
     *         <li></li>
     *     </ul>
     *     <i>comments</i> will be operated in a different method.
     * </p>
     * @param managerDto manager DTO to be acted on
     * @return
     */
    FundManagerDto update(@NotNull @Valid FundManagerDto managerDto);

    FundManagerDto addNote(@NotBlank String note, @NotNull @Positive Long managerId);
}
