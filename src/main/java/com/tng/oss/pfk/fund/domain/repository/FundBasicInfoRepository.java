package com.tng.oss.pfk.fund.domain.repository;

import com.tng.oss.pfk.fund.domain.model.FundBasicInfo;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FundBasicInfoRepository extends BaseRepository<FundBasicInfo>, JpaSpecificationExecutor<FundBasicInfo> {

    Optional<FundBasicInfo> findByCodeIgnoreCase(String code);
}
