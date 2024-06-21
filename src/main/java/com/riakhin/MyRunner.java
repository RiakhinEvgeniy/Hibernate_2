package com.riakhin;

import com.riakhin.config.SessionCreator;
import org.hibernate.Session;

public class MyRunner {
    public static void main(String[] args) {
        Session session = SessionCreator.getSession();
    }
}
