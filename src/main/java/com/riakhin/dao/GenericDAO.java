package com.riakhin.dao;

import org.hibernate.Session;

import java.util.List;

public abstract class GenericDAO<T> {

    private final Class<T> clazz;
    private final Session session;

    public GenericDAO(final Class<T> clazz, Session session) {
        this.clazz = clazz;
        this.session = session;
    }

    public T getById(final int id) {
        return (T) session.get(clazz, id);
    }

    public List<T> getItems(int offset, int limit ) {
        session.beginTransaction();
        return session.createQuery("from "+clazz.getName(), clazz).list();
    }

    public List<T> findAll() {
        return session.createQuery("from "+clazz.getName(), clazz).list();
    }

    public T save(final T entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        session.update(entity);
        return entity;
    }

    public void delete(final T entity) {
        session.delete(entity);
    }

    public void deleteById(final int id) {
        session.delete(getById(id));
    }

    public Session getCurrentSession() {
        return session;
    }
}
