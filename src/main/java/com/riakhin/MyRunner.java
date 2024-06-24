package com.riakhin;

import com.riakhin.dao.*;
import com.riakhin.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MyRunner {

    static SessionFactory sessionFactory = null;

    private final ActorDAO actorDAO;
    private final StoreDAO storeDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FeaturesDAO featuresDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RatingDAO ratingDAO;
    private final StaffDAO staffDAO;
    private final RentalDAO rentalDAO;

    public MyRunner() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        actorDAO = new ActorDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        featuresDAO = new FeaturesDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        ratingDAO = new RatingDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
    }

    public static void main(String[] args) {
        MyRunner myRunner = new MyRunner();
        Customer customer = myRunner.createCustomer();
//        myRunner.customerReturnedFilm();
        myRunner.customerTakeFilm(customer);

    }

    private void customerTakeFilm(Customer customer) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Film film = filmDAO.getFirstFilm();

            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Staff staff = store.getManagerStaffId();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomerId(customer);
            rental.setStaffId(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaffId(staff);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRentalId(rental);
            payment.setAmount(BigDecimal.valueOf(75.75));
            paymentDAO.save(payment);



            session.getTransaction().commit();
        }
    }

    private void customerReturnedFilm() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDAO.rentalReturnNot();
            rental.setReturnDate(LocalDateTime.now());

            rentalDAO.save(rental);

            session.getTransaction().commit();
        }
    }
    private Customer createCustomer() {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);

            City city = cityDAO.getCityByName("Baku");

            Address address = Address.builder()
                    .address("Schlesierweg 5")
                    .city(city)
                    .district("Laagberg")
                    .phoneNumber("123456789")
                    .postalCode("38440")
                    .build();
            session.save(address);

            Customer customer = Customer.builder()
                    .activeStatus(true)
                    .addressId(address)
                    .name("Natala")
                    .store(store)
                    .email("natala@riakhin.com")
                    .lastName("Riakhina")
                    .build();

            session.save(customer);

            session.getTransaction().commit();
            return customer;
        }
    }
}
