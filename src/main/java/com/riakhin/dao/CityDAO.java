package com.riakhin.dao;

import com.riakhin.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends GenericDAO<City> {

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getCityByName(String cityName) {
            Query<City> query = getCurrentSession().createQuery("select c from City c where c.city = :name", City.class);
            query.setParameter("name", cityName);
            return query.getSingleResult();
    }
}
