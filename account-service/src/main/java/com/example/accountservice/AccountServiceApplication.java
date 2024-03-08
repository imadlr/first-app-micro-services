package com.example.accountservice;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.findAllCustomers().forEach(c -> {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(80000)
                        .type(AccountType.CURRENT_ACCOUNT)
                        .createdAt(LocalDate.now())
                        .currency("MAD")
                        .customerId(c.getId())
                        .build();

                BankAccount bankAccount1 = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(80000)
                        .type(AccountType.SAVING_ACCOUNT)
                        .createdAt(LocalDate.now())
                        .currency("MAD")
                        .customerId(c.getId())
                        .build();

                bankAccountRepository.saveAll(List.of(bankAccount, bankAccount1));
            });
        };
    }
}
