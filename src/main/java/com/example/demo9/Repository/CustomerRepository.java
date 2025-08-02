package com.example.demo9.Repository;

import com.example.demo9.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if (customer.getCusID() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Integer id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public List<Customer> findAllCustomerWithName(String cusName) {
        List<Customer> customers = entityManager.createNamedQuery("findAllCustomerWithName")
                .setParameter("cusName", cusName)
                .getResultList();
        return customers;
    }

    public Integer findLastIdFromDatabsae(){ //để khi tạo dữ liệu mới có thể tìm được id tiếp theo để insert vào db
        TypedQuery<Integer> query = entityManager.createQuery("SELECT MAX(c.cusID) FROM Customer c", Integer.class);
        return query.getSingleResult();
    }
}