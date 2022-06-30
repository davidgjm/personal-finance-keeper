package com.tng.oss.reactive.sandbox.domain.repository;

import com.tng.oss.reactive.sandbox.domain.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    Flux<Customer> findByLastName(String lastName);
}
