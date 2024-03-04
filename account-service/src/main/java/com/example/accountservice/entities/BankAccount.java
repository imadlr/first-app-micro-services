package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient // ignorer cet attribut lors de la création de la table
    private Customer customer;
    private Long customerId;
}
