package com.riakhin.dao;

import com.riakhin.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDAO extends GenericDAO<Category>{

    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
