package com.riakhin.dao;

import com.riakhin.entity.Inventory;
import org.hibernate.Session;

public class InventoryDAO extends GenericDAO<Inventory> {

    public InventoryDAO(Session session) {
        super(Inventory.class, session);
    }
}
