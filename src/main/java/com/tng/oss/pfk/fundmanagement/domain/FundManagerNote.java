package com.tng.oss.pfk.fundmanagement.domain;

import com.tng.oss.pfk.fundmanagement.domain.dtos.FundManagerComment;
import com.tng.oss.pfk.infrastructure.core.validation.GenericAssertions;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

@Data
@Embeddable
@EqualsAndHashCode
@Setter(AccessLevel.NONE)
@AllArgsConstructor
@NoArgsConstructor
public final class FundManagerNote implements Comparable<FundManagerNote> {

    @NotBlank
    @Column(nullable = false, length = 65535)
    private String comment;

    @NotNull
    @PastOrPresent
    @Column(nullable = false, updatable = false)
    private Instant commentedOn;

    @Column(length = 40)
    private String commentedBy;

    @Override
    public int compareTo(FundManagerNote o) {
        return this.getCommentedOn().compareTo(o.commentedOn) * -1;
    }

    public static FundManagerNote of(@NotBlank String note, @NotNull @PastOrPresent Instant commentedOn, String commentedBy) {
        GenericAssertions.hasText(note);

        GenericAssertions.notFuture(commentedOn, "commentedOn cannot be future");
        return new FundManagerNote(note, commentedOn, commentedBy);
    }

    public static FundManagerNote of(@NotBlank String note) {
        GenericAssertions.hasText(note);
        return new FundManagerNote(note, Instant.now(), "SYSTEM");
    }

    public static FundManagerNote of(@Valid FundManagerComment comment) {
        GenericAssertions.notNull(comment, "FundManagerComment cannot be null!");
        return new FundManagerNote(comment.getComment(), comment.getCommentedOn(), comment.getCommentedBy());
    }
}
