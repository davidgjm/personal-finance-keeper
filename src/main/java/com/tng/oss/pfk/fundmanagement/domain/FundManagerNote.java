package com.tng.oss.pfk.fundmanagement.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Data
@Embeddable
@EqualsAndHashCode
public final class FundManagerNote implements Comparable<FundManagerNote> {

    @NotBlank
    @Column(nullable = false, length = 65535)
    private String comment;

    @Column(length = 40)
    private String commentedBy;

    @NotNull
    @PastOrPresent
    @Column(nullable = false, updatable = false)
    private LocalDateTime commentedOn;

    @Override
    public int compareTo(FundManagerNote o) {
        return this.getCommentedOn().compareTo(o.commentedOn) * -1;
    }
}
