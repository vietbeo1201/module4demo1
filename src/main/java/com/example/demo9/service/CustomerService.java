package com.example.demo9.service;

import com.example.demo9.Repository.ICustomerRepository;
import com.example.demo9.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Service                                                                        // auto create bean
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.remove(id);
    }

    @Override
    public List<Customer> findAllCustomerWithName(String cusName) {

        return iCustomerRepository.findAllCustomerWithName(cusName);
    }

    // reading file hibernate.conf.xml
    /*private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Customer> findAll() {
        String hql = "SELECT c FROM Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(hql, Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        Transaction transaction = null;
        Customer origin;
        if (customer.getCusID() == 0) {
            origin = new Customer();
        } else {
            origin = findById(customer.getCusID());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setCusName(customer.getCusName());
            origin.setCusEmail(customer.getCusEmail());
            origin.setCusAddress(customer.getCusAddress());
            origin.setCusPhone(customer.getCusPhone());
            origin.setCusImage(customer.getCusImage());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Customer findById(int id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }



    @Override
    public void remove(int id) {

    }*/
}
