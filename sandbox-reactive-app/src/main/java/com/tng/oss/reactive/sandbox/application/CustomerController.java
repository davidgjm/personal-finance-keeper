package com.tng.oss.reactive.sandbox.application;

import com.tng.oss.reactive.sandbox.domain.model.Customer;
import com.tng.oss.reactive.sandbox.domain.service.CustomerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping
    public Flux<Customer> findPersons() {
        log.info("Querying current persons in database");
        return customerService.findAll()
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(customer -> log.info("Persisted entity: {}", customer))
        ;
    }

    @PostMapping
    public Mono<CustomerDto> save(@RequestBody Mono<CustomerDto> requestBody) {
        return requestBody
                .publishOn(Schedulers.boundedElastic())
                .map(CustomerDto::customer)
                .flatMap(customerService::save)
                .map(CustomerDto::from)
                ;
    }

    @Data
    public static class CustomerDto {
        private String firstName;
        private String lastName;

        public Customer customer() {
            return new Customer(firstName, lastName);
        }

        public static CustomerDto from(Customer customer) {
            var dto = new CustomerDto();
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            return dto;
        }
    }
}
