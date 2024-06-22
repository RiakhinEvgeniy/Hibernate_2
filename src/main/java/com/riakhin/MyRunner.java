package com.riakhin;

import com.riakhin.config.SessionCreator;
import com.riakhin.dao.*;
import com.riakhin.entity.City;
import org.hibernate.Session;

public class MyRunner {

    static Session session = null;

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
    private final RentalDAO rentalDAO;

    public MyRunner() {
        session = SessionCreator.getSession();
        actorDAO = new ActorDAO(session);
        storeDAO = new StoreDAO(session);
        addressDAO = new AddressDAO(session);
        categoryDAO = new CategoryDAO(session);
        cityDAO = new CityDAO(session);
        countryDAO = new CountryDAO(session);
        customerDAO = new CustomerDAO(session);
        featuresDAO = new FeaturesDAO(session);
        filmDAO = new FilmDAO(session);
        filmTextDAO = new FilmTextDAO(session);
        inventoryDAO = new InventoryDAO(session);
        languageDAO = new LanguageDAO(session);
        paymentDAO = new PaymentDAO(session);
        ratingDAO = new RatingDAO(session);
        rentalDAO = new RentalDAO(session);
    }

    public static void main(String[] args) {
        MyRunner myRunner = new MyRunner();
        City city = myRunner.getCity("Aden");
        System.out.println(city.getCity());
    }

    private City getCity(String name) {
        return cityDAO.getCityByName(name);
    }
}
