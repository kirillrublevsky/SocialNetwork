package com.network.dao.impl;

import com.network.dao.PlaceDao;
import com.network.dao.entity.Contact;
import com.network.dao.entity.Place;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PlaceDaoImpl() {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Place> getAllPlaces() {
        return sessionFactory.getCurrentSession().createQuery("FROM Place").list();
    }

    @Override
    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @Override
    public void deletePlace(long placeId){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE Place WHERE id = :placeId");
        query.setParameter("placeId", placeId);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getAllContactsWithPlace(long placeId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT c FROM Contact c JOIN c.places p WHERE p.id = :placeId");
        query.setParameter("placeId", placeId);
        return query.list();
    }

    @Override
    public void addPlaceToContact(long placeId, long contactId) {
        Session session = sessionFactory.getCurrentSession();
        Place placeLoaded = (Place) session.load(Place.class, placeId);
        Contact contactLoaded = (Contact) session.load(Contact.class, contactId);
        contactLoaded.getPlaces().add(placeLoaded);
        session.update(contactLoaded);
    }

}
