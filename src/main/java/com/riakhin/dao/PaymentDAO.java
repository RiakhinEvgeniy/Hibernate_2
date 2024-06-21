package com.riakhin.dao;

import com.riakhin.entity.Payment;
import org.hibernate.Session;

public class PaymentDAO extends GenericDAO<Payment> {

    public PaymentDAO(Session session) {
        super(Payment.class, session);
    }
}
