package com.riakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAO<T> {

    private final Class<T> clazz;
    private final Session session;

    public GenericDAO(final Class<T> clazz, Session session) {
        this.clazz = clazz;
        this.session = session;
    }

    public List<T> getItems(int offset, int limit ) {
        session.beginTransaction();
        return session.createQuery("from "+clazz.getName(), clazz).list();
    }
}
