package com.network.dao;

import com.network.dao.entity.Contact;
import com.network.dao.entity.Place;

import java.util.List;

public interface PlaceDao {

    void addPlace(Place place);
    void deletePlace(long placeId);
    List<Contact> getAllContactsWithPlace(long placeId);
    void addPlaceToContact(long placeId, long contactId);
    List<Place> getAllPlaces();
}
