package com.riakhin.dao;

import com.riakhin.entity.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RatingDAO extends GenericDAO<Rating> {

    public RatingDAO(SessionFactory sessionFactory) {
        super(Rating.class, sessionFactory);
    }
}
