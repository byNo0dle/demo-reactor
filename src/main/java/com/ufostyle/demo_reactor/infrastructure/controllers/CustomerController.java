package com.ufostyle.demo_reactor.infrastructure.controllers;

import com.ufostyle.demo_reactor.domain.models.Customer;
import com.ufostyle.demo_reactor.domain.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Flux<Customer>> findAllCustomer() {
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<Mono<Customer>> findByIdCustomer(
            @PathVariable("idCustomer") String idCustomer) {
        Mono<Customer> entity = customerService.findByIdCustomer(idCustomer);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
        Mono<Customer> entity = customerService.createCustomer(customer);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idCustomer}")
    public ResponseEntity<Mono<Customer>> updateCustomer(
            @PathVariable("idCustomer") String idCustomer, @RequestBody Customer customer) {
        //Get Customer Id
        Mono<Customer> updateCustomers = customerService.findByIdCustomer(idCustomer);
        //Update Customer
        updateCustomers = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updateCustomers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCustomer}")
    public ResponseEntity<Mono<Void>> deleteCustomer(
            @PathVariable("idCustomer") String idCustomer) {
        Mono<Void> entity = customerService.deleteCustomer(idCustomer);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
