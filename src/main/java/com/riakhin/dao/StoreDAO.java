package com.riakhin.dao;

import com.riakhin.entity.Store;
import org.hibernate.Session;

public class StoreDAO extends GenericDAO<Store> {

    public StoreDAO(Session session) {
        super(Store.class, session);
        System.out.println("StoreDAO");
    }

}
