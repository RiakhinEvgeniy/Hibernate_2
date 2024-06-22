package com.riakhin.dao;

import com.riakhin.entity.Features;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FeaturesDAO extends GenericDAO<Features> {

    public FeaturesDAO(SessionFactory sessionFactory) {
        super(Features.class, sessionFactory);
    }
}
