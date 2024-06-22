package com.riakhin.dao;

import com.riakhin.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FilmDAO extends GenericDAO<Film> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
