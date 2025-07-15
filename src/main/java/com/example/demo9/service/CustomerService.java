package com.example.demo9.service;

import com.example.demo9.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService implements iGeneralService<Customer> {

    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John Doe", "123 Elm Street", "555-1234", "john@example.com"));
        customers.put(2, new Customer(2, "Jane Smith", "456 Oak Avenue", "555-5678", "jane.smith@example.com"));
        customers.put(3, new Customer(3, "David Nguyen", "789 Pine Road", "0909-888-777", "davidn@vnmail.vn"));
        customers.put(4, new Customer(4, "Maria Garcia", "12 Maple Lane", "555-1010", "maria.garcia@example.com"));
        customers.put(5, new Customer(5, "Lê Văn A", "10 Lý Thường Kiệt, Hà Nội", "0912-345-678", "leva@example.vn"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getCusID(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
