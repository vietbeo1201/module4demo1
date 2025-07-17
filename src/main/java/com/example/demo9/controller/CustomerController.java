package com.example.demo9.controller;

import com.example.demo9.customer.Customer;
import com.example.demo9.customer.CustomerForm;
import com.example.demo9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Value("${file-upload}") private String fileUpload;

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
    public String save(@ModelAttribute("customer") CustomerForm customerForm, Model model){
        MultipartFile multipartFile = customerForm.getCusImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(customerForm.getCusImage().getBytes(),new File(fileUpload + fileName));
            // change image into byte create new File with absolute path + file name(example: viet.img)
        } catch (IOException e) {
            e.printStackTrace();
        }

        // prepare data to right data type for input into database
        Customer customer = new Customer(customerForm.getCusID(), customerForm.getCusName(), customerForm.getCusAddress(),
                                        customerForm.getCusPhone(), customerForm.getCusEmail(), fileName);

        customerService.save(customer);
        model.addAttribute("customer", customer);
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
