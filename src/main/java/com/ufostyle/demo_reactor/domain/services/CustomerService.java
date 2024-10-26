package com.ufostyle.demo_reactor.domain.services;

import com.ufostyle.demo_reactor.domain.models.Customer;
import com.ufostyle.demo_reactor.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Flux<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Mono<Customer> findByIdCustomer(String idCustomer) {
        return customerRepository.findById(idCustomer);
    }

    public Mono<Customer> createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Customer> updateCustomer(Customer customer) {
        return customerRepository.findById(customer.getIdCustomer())
                .flatMap(updateCustomers -> {
                    updateCustomers.setIdCustomer(customer.getIdCustomer());
                    updateCustomers.setFirstName(customer.getFirstName());
                    updateCustomers.setLastName(customer.getLastName());
                    updateCustomers.setEmailCustomer(customer.getEmailCustomer());
                    updateCustomers.setPhoneNumber(customer.getPhoneNumber());

                    return customerRepository.save(updateCustomers);
                });
    }

    public Mono<Void> deleteCustomer(String idCustomer) {
        return customerRepository.deleteById(idCustomer);
    }
}
