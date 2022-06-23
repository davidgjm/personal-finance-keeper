package com.tng.oss.pfk.fundmanagement.domain.model;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerCommentDto;
import com.tng.oss.pfk.infrastructure.core.persistence.BaseEntity;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@Setter(AccessLevel.NONE)
@NoArgsConstructor
@Entity
public final class FundManagerComment extends BaseEntity implements Comparable<FundManagerComment> {
    @NotNull
    @Positive
    @Column(nullable = false, updatable = false)
    private Long managerId;

    @NotBlank
    @Column(nullable = false, length = 65535)
    private String comment;

    @NotNull
    @PastOrPresent
    @Column(nullable = false, updatable = false)
    private Instant commentedOn;

    @Column(length = 40)
    private String commentedBy;

    private FundManagerComment(Long managerId, String comment, Instant commentedOn, String commentedBy) {
        GenericAssertions.isTrue(managerId != null && managerId > 0, "managerId invalid!");
        GenericAssertions.hasText(comment, "Comment cannot be empty!");
        GenericAssertions.notFuture(commentedOn, "CommentedOn cannot be in the future!");
        this.managerId = managerId;
        this.comment = comment;
        this.commentedOn = commentedOn;
        this.commentedBy = commentedBy;
    }

    private FundManagerComment(Long managerId, @NotBlank String comment, String commentedBy) {
        this(managerId, comment, Instant.now(), commentedBy);
    }

    private FundManagerComment(Long managerId, @NotBlank String comment) {
        this(managerId, comment, null);
    }

    @Override
    public int compareTo(FundManagerComment o) {
        return this.getCommentedOn().compareTo(o.commentedOn) * -1;
    }

    public static FundManagerComment of(@NotNull @Positive Long managerId, @NotBlank String note, String commentedBy) {
        return new FundManagerComment(managerId, note, commentedBy);
    }

    public static FundManagerComment of(@NotNull @Positive Long managerId, @NotBlank String note) {
        return new FundManagerComment(managerId, note, "SYSTEM");
    }

    public static FundManagerComment of(@Valid FundManagerCommentDto comment) {
        GenericAssertions.notNull(comment, "FundManagerComment cannot be null!");
        return new FundManagerComment(comment.getManagerId(), comment.getComment(), comment.getCommentedOn(), comment.getCommentedBy());
    }
}
