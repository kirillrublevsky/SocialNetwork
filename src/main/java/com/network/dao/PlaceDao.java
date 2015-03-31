package com.network.dao;

import com.network.model.Contact;
import com.network.model.Hobby;
import com.network.model.Place;

import java.util.Set;

public interface PlaceDao {

    void addPlace(Place place);
    Set<Contact> getAllContactsWithPlace(Place place);
    void addPlaceToContact(Place place, Contact contact);

    Set<Place> getPlaces();
}
