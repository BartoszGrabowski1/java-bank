package com.javabank.javabankapp.controller;

import com.javabank.javabankapp.config.JavaBankUserDetails;
import com.javabank.javabankapp.config.LoginRequest;
import com.javabank.javabankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    CustomerService  customerService;
    JavaBankUserDetails javaBankUserDetails;

    @Autowired
    public LoginController(CustomerService customerService, JavaBankUserDetails javaBankUserDetails) {
        this.customerService = customerService;
        this.javaBankUserDetails = javaBankUserDetails;
    }


}
