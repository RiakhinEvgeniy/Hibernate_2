package com.riakhin.dao;

import com.riakhin.entity.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PaymentDAO extends GenericDAO<Payment> {

    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
