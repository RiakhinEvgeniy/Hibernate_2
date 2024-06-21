package com.riakhin.dao;

import com.riakhin.entity.Address;
import org.hibernate.Session;

public class AddressDAO extends GenericDAO<Address> {

    public AddressDAO(Session session) {
        super(Address.class, session);
    }
}
