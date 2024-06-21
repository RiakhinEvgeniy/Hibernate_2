package com.riakhin.dao;

import com.riakhin.entity.Language;
import org.hibernate.Session;

public class LanguageDAO extends GenericDAO<Language> {

    public LanguageDAO(Session session) {
        super(Language.class, session);
    }
}
