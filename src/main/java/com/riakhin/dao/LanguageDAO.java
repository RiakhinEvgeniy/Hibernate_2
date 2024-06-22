package com.riakhin.dao;

import com.riakhin.entity.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LanguageDAO extends GenericDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
