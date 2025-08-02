package com.example.demo9.Repository;

import com.example.demo9.model.Customer;

import java.util.List;

public interface ICustomerRepository extends IGeneralRepository<Customer> {
    List<Customer> findAllCustomerWithName(String cusName);
}
