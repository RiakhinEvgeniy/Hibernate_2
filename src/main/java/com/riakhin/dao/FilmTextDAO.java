package com.riakhin.dao;

import com.riakhin.entity.FilmText;
import org.hibernate.Session;

public class FilmTextDAO extends GenericDAO<FilmText> {

    public FilmTextDAO(Session session) {
        super(FilmText.class, session);
    }
}
