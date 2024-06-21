package com.riakhin.dao;

import com.riakhin.entity.Features;
import org.hibernate.Session;

public class FeaturesDAO extends GenericDAO<Features> {

    public FeaturesDAO(Session session) {
        super(Features.class, session);
    }
}
