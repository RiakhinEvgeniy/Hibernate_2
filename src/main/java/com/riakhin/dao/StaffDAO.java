package com.riakhin.dao;

import com.riakhin.entity.Staff;
import org.hibernate.Session;

public class StaffDAO extends GenericDAO<Staff> {

    public StaffDAO(Session session) {
        super(Staff.class, session);
    }
}
