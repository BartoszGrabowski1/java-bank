package com.javabank.javabankapp.service;

import com.javabank.javabankapp.Utils.EmailValidator;
import com.javabank.javabankapp.model.Customer;
import com.javabank.javabankapp.model.CustomerDto;
import com.javabank.javabankapp.model.CustomerRole;
import com.javabank.javabankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public static final Long EMPTY_ID = null;
    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isCustomerDataValid(CustomerDto customerDto){
        if(EmailValidator.patternMatches(customerDto.getEmail()) && customerDto.getPassword().length() > 6){
            return true;
        }
        return false;
    }

    public void createCustomer(CustomerDto customerDto){
        customerRepository.save(new Customer(
                EMPTY_ID,
                customerDto.getEmail(),
                customerDto.getName(),
                customerDto.getSurname(),
                passwordEncoder.encode(customerDto.getPassword()),
                CustomerRole.USER));
    }

}
