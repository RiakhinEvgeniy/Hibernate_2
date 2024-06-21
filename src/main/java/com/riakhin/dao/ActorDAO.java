package com.riakhin.dao;

import com.riakhin.entity.Actor;
import org.hibernate.Session;

public class ActorDAO extends GenericDAO<Actor> {

    public ActorDAO(Session session) {
        super(Actor.class, session);
        System.out.println("StoreDAO");
    }
}
