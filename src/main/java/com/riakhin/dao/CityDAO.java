package com.riakhin.dao;

import com.riakhin.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CityDAO extends GenericDAO<City> {

    public CityDAO(Session session) {
        super(City.class, session);
    }

    public City getCityByName(String cityName) {
        Transaction tx = null;
        try (Session session = getCurrentSession()) {
            tx = session.getTransaction();
            tx.begin();
            Query<City> query = session.createQuery("select c from City c where c.city = :name", City.class);
            query.setParameter("name", cityName);
            tx.commit();
            return query.getSingleResult();
        } catch (Exception e) {
            assert tx != null;
            tx.rollback();
        }
        return null;
    }
}
