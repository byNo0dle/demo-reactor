package com.ufostyle.demo_reactor.domain.repositories;

import com.ufostyle.demo_reactor.domain.models.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
}
