package com.riakhin.dao;

import com.riakhin.entity.Category;
import org.hibernate.Session;

public class CategoryDAO extends GenericDAO<Category>{

    public CategoryDAO(Session session) {
        super(Category.class, session);
    }
}
