package com.example.demo9.controller;

import com.example.demo9.customer.Customer;
import com.example.demo9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/management")
    public String findAll(Model model) {        // after handle customers it will send data into url: WEB-INF/views/customer/list.html
        List<Customer> customerList =  customerService.findAll();
        model.addAttribute("customers", customerList);
        model.addAttribute("message", "welcome to management page");
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }



//    @GetMapping("/list/{name}/{age}/{email}")   // /customer/list/viet/24/viet@gmail.com
//    public String List(@PathVariable String name, @PathVariable String age, @PathVariable String email) {
//        List<Customer> customerList = customerService.findAll();
//        return customerList.toString();
//    }

//    @GetMapping("/list")   //   /customer/list?name=viet&age=24&email=viet@gmail.com
//    public String List(@RequestParam String name, @RequestParam String age, @RequestParam String email) {
//        List<Customer> customerList = customerService.findAll();
//        return customerList.toString();
//    }


    /*@ModelAttribute ("Customer")
    public Customer getCustomerByID(@PathVariable("cusID") int cusID) {
        return customerService.findById(cusID);
    }
    @GetMapping("/list/{cusID}")   //   /customer/list/3
    public String List(@ModelAttribute("khach_hang") Customer customer) {
        List<Customer> customerList = customerService.findAll();
        return customerList.toString();
    }*/
}
