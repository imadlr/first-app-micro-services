package com.example.accountservice.clients;

import com.example.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> findAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("default");
        customer.setLastName("default");
        customer.setEmail("");
        return customer;
    }

    default List<Customer> getDefaultCustomers(Exception exception) {
        return new ArrayList<>();
    }
}
