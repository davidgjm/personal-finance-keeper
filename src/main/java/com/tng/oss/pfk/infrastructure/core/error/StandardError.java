package com.tng.oss.pfk.infrastructure.core.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements GenericError {
    @JsonProperty(required = true)
    private int code;

    @JsonProperty(required = true)
    private  String message;

    public static StandardError of(@NotNull @Valid GenericError error) {
        return new StandardError(error.getCode(), error.getMessage());
    }
}
