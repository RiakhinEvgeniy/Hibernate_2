package com.riakhin.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {

    public static Session getSession() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
           return sessionFactory.openSession();
        }
    }
}
