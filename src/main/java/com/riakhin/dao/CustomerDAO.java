package com.riakhin.dao;

import com.riakhin.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDAO extends GenericDAO<Customer>{

    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
