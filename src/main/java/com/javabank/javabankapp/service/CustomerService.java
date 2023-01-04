package com.javabank.javabankapp.service;

import com.javabank.javabankapp.Utils.EmailValidator;
import com.javabank.javabankapp.model.Customer;
import com.javabank.javabankapp.model.CustomerDto;
import com.javabank.javabankapp.model.CustomerRole;
import com.javabank.javabankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean isCustomerDataValid(CustomerDto customerDto){
        if(EmailValidator.patternMatches(customerDto.getEmail()) && customerDto.getPassword().length() > 6){
            return true;
        }
        return false;
    }

    public void createCustomer(CustomerDto customerDto){
        customerRepository.save(new Customer(null, customerDto.getEmail(), customerDto.getName(), customerDto.getSurname(), customerDto.getPassword(), CustomerRole.USER));
    }

//    public boolean


}
