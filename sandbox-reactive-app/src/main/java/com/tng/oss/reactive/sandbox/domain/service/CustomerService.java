package com.tng.oss.reactive.sandbox.domain.service;

import com.tng.oss.reactive.sandbox.domain.model.Customer;
import com.tng.oss.reactive.sandbox.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository repository;

    public Mono<Customer> save(Customer customer) {
        log.info("attempting to save person {}", customer);
        return repository.save(customer)
                ;
    }

    public Flux<Customer> findByName(String name) {
        return repository.findByLastName(name);
    }

    public Flux<Customer> findAll() {
        return repository.findAll();
    }
}
