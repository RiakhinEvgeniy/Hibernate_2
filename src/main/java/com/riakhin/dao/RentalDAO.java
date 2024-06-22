package com.riakhin.dao;

import com.riakhin.entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
