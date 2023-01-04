package com.javabank.javabankapp.controller;

import com.javabank.javabankapp.model.CustomerDto;
import com.javabank.javabankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {


    CustomerService customerService;

    @Autowired
    public RegistrationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewCustomer(@RequestBody CustomerDto customerDto){
        if (customerService.isCustomerDataValid(customerDto)){
            customerService.createCustomer(customerDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Successfully registered!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Incorrect data! Check email and password!");
        }
    }

}
