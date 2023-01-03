package com.javabank.javabankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails(){
        return "There will be the user balance details from the DB";
    }
}
