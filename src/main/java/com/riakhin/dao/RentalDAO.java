package com.riakhin.dao;

import com.riakhin.entity.Rental;
import org.hibernate.Session;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO(Session session) {
        super(Rental.class, session);
    }
}
