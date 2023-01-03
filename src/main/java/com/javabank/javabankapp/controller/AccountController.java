package com.javabank.javabankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/details")
    public String getAccountDetails(){
        return "There will be user account details loaded from DB";
    }
}
