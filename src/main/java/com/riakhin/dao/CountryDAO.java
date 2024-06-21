package com.riakhin.dao;

import com.riakhin.entity.Country;
import org.hibernate.Session;

public class CountryDAO extends GenericDAO<Country> {

    public CountryDAO(Session session) {
        super(Country.class, session);
    }
}
