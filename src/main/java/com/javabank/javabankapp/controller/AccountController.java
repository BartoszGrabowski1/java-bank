package com.javabank.javabankapp.controller;

import com.javabank.javabankapp.model.Customer;
import com.javabank.javabankapp.model.CustomerDto;
import com.javabank.javabankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    CustomerService customerService;

    @Autowired
    public AccountController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/details/{id}")
    public Customer getAccountDetails(@PathVariable Long id){
        return customerService.getCustomerDetails(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomerDetails(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        customerService.updateCustomerDetails(id,customerDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body("resource updated successfully");
    }


}
