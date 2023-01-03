package com.javabank.javabankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansController {

    @GetMapping("/myLoans")
    public String getLoanDetails(){
        return "There will be loan details";
    }
}
