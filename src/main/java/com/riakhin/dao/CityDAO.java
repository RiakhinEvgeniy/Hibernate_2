package com.riakhin.dao;

import com.riakhin.entity.City;
import org.hibernate.Session;

public class CityDAO extends GenericDAO<City>{

    public CityDAO(Session session) {
        super(City.class, session);
    }
}
