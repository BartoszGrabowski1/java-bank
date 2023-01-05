package com.javabank.javabankapp.controller;

import com.javabank.javabankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    CustomerService customerService;

    @Autowired
    public AccountController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/details")
    public String getAccountDetails(){
        return "There will be user account details loaded from DB";
    }
}
