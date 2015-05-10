package com.network.service;

import com.network.model.ContactDTO;
import com.network.model.HobbyDTO;

import java.util.List;

public interface HobbyService {

    void addHobby(String title, String description);
    void removeHobby(long hobbyId);
    List<ContactDTO> getAllContactsWithHobby(long hobbyId);
    void addHobbyToContact(long hobbyId, long contactId);
    List<HobbyDTO> getAllHobbies();
}
