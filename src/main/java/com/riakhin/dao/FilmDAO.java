package com.riakhin.dao;

import com.riakhin.entity.Film;
import org.hibernate.Session;

public class FilmDAO extends GenericDAO<Film> {

    public FilmDAO(Session session) {
        super(Film.class, session);
    }
}
