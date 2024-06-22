package com.riakhin.dao;

import com.riakhin.entity.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends GenericDAO<Country> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
