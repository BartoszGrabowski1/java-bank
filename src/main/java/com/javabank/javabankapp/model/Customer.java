package com.javabank.javabankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;
    private String email;
    private String name;
    private String surname;
    private String password;
    @Enumerated(EnumType.STRING)
    private CustomerRole role;

}
