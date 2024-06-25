package com.riakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class GenericDAO<T> {

    private final Class<T> clazz;
    private final SessionFactory sessionFactory;

    public GenericDAO(final Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public T getById(final int id) {
        return getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int offset, int limit ) {
        Query<T> query = getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from "+clazz.getName(), clazz).list();
    }

    public T save(final T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public T update(final T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(final int id) {
        getCurrentSession().delete(getById(id));
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
