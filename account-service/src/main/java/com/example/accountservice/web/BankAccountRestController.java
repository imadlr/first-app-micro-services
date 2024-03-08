package com.example.accountservice.web;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.models.Customer;
import com.example.accountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
