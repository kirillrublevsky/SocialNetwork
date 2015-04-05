package com.network.dao;

import com.network.model.Contact;
import com.network.model.Place;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlaceDaoImpl implements PlaceDao {

    private Set<Place> places;

    private ContactDao contactDao;

    public PlaceDaoImpl() {}

    public ContactDao getContactDao() {
        return contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    @Override
    public Set<Place> getAllPlaces() {
        return places;
    }

    @Override
    public void addPlace(Place place) {
        places.add(place);
    }

    @Override
    public Set<Contact> getAllContactsWithPlace(Place place) {
        Set<Contact> contactSet = new HashSet<Contact>();
        Set<Contact> contacts = contactDao.getAllContacts();
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            Set<Place> placeSet = contact.getPlaces();
            if(placeSet.contains(place)){
                contactSet.add(contact);
            }
        }
        return contactSet;
    }

    @Override
    public void addPlaceToContact(Place place, Contact contact) {
        addPlace(place);
        contact.getPlaces().add(place);
    }

}
