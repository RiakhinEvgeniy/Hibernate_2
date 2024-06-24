package com.riakhin.dao;

import com.riakhin.entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental rentalReturnNot() {
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.returnDate is NULL ", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
