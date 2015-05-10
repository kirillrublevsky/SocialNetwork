package com.network.service;

import com.network.model.ContactDTO;
import com.network.model.PlaceDTO;

import java.util.List;

public interface PlaceService {

    void addPlace(String title, String description, double longitude, double latitude);
    void removePlace(long placeId);
    List<ContactDTO> getAllContactsWithPlace(long placeId);
    void addPlaceToContact(long placeId, long contactId);
    List<PlaceDTO> getAllPlaces();
}
