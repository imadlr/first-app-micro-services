package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "customer1", "customer1", "customer1@gmail.com"));
            customerRepository.save(new Customer(null, "customer2", "customer2", "customer2@gmail.com"));
            customerRepository.save(new Customer(null, "customer3", "customer3", "customer3@gmail.com"));
            customerRepository.save(new Customer(null, "customer4", "customer4", "customer4@gmail.com"));
            customerRepository.save(new Customer(null, "customer5", "customer5", "customer5@gmail.com"));
        };
    }

}
