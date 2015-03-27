package com.network.dao;

import com.network.model.Contact;
import com.network.model.Place;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlaceDaoImpl implements PlaceDao {

    private Set<Place> places;

    public PlaceDaoImpl() {}

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    @Override
    public Set<Place> getPlaces() {
        return places;
    }

    @Override
    public void addPlace(Place place) {
        places.add(place);
    }

    @Override
    public Set<Contact> getAllContactsWithPlace(Place place, Set<Contact> contacts) {
        Set<Contact> contactSet = new HashSet<Contact>();
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
