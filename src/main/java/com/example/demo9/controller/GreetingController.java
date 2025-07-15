package com.example.demo9.controller;

import com.example.demo9.customer.Customer;
import com.example.demo9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/greeting")
    public String greeting() {
        List<Customer> customerList = customerService.findAll();
        return "index";
    }
}