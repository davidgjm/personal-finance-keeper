package com.tng.oss.reactive.sandbox.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
public class Customer {
    @Id
    private Long id;

    private final String firstName;
    private final String lastName;
}
