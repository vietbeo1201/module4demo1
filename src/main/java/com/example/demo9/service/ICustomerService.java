package com.example.demo9.service;

import com.example.demo9.model.Customer;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findAllCustomerWithName(String cusName);
}
