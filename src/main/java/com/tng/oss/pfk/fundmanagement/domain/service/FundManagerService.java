package com.tng.oss.pfk.fundmanagement.domain.service;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerDto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

public interface FundManagerService {
    /**
     * Finds all fund managers in a company
     *
     * @param companyId Company Id
     * @return
     */
    List<FundManagerDto> all(@NotNull @Positive Long companyId);

    /**
     * Find all managers with the provided name.
     * <b>Note that 2 different managers may have the same name.</b>
     * @param name
     * @return
     */
    List<FundManagerDto> of(@NotBlank String name);

    Optional<FundManagerDto> of(@NotNull @Positive Long managerId);

    /**
     * Create or update a fund manager record.
     * <p>
     *     <i>create</i> or <i>update</i> action is decided by its ID field.
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
    FundManagerDto save(@NotNull @Valid FundManagerDto managerDto);

    FundManagerDto addNote(@NotBlank String note, @NotNull @Positive Long managerId);
}
