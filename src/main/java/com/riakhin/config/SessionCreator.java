package com.riakhin.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {

    public void getSession() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
        }

        //return sessionFactory.openSession();
    }
}
