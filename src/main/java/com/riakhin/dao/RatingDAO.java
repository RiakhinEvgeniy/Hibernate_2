package com.riakhin.dao;

import com.riakhin.entity.Rating;
import org.hibernate.Session;

public class RatingDAO extends GenericDAO<Rating> {

    public RatingDAO(Session session) {
        super(Rating.class, session);
    }
}
