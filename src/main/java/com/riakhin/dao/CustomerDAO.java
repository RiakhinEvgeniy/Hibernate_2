package com.riakhin.dao;

import com.riakhin.entity.Customer;
import org.hibernate.Session;

public class CustomerDAO extends GenericDAO<Customer>{

    public CustomerDAO(Session session) {
        super(Customer.class, session);
    }
}
