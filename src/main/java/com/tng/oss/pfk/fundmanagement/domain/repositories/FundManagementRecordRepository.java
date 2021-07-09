package com.tng.oss.pfk.fundmanagement.domain.repositories;

import com.tng.oss.pfk.fundmanagement.domain.model.FundManagementRecord;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FundManagementRecordRepository extends BaseRepository<FundManagementRecord> {
    @Query("SELECT r FROM FundManagementRecord r WHERE r.fundId = :fundId ORDER BY r.start DESC")
    List<FundManagementRecord> findAllByFundId(@Param("fundId") Long fundId);

    @Query("SELECT r FROM FundManagementRecord r WHERE r.managerId = :managerId ORDER BY r.start DESC")
    List<FundManagementRecord> findAllByManagerId(@Param("managerId") Long managerId);
}
