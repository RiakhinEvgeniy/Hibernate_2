package com.riakhin.dao;

import com.riakhin.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressDAO extends GenericDAO<Address> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
