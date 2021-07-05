package com.tng.oss.pfk.fundmanagement.domain.repositories;

import com.tng.oss.pfk.fundmanagement.domain.model.FundManagerComment;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseRepository;

import java.util.List;

public interface FundManagerCommentRepository extends BaseRepository<FundManagerComment> {
    List<FundManagerComment> findAllByManagerIdOrderByCommentedOnDesc(Long managerId);
}
