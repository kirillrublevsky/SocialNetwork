package com.network.dao;

import com.network.dao.entity.Contact;
import com.network.dao.entity.Hobby;

import java.util.List;

public interface HobbyDao {

    void addHobby(Hobby hobby);
    void deleteHobby(long hobbyId);
    List<Contact> getAllContactsWithHobby(long hobbyId);
    void addHobbyToContact(long hobbyId, long contactId);
    List<Hobby> getAllHobbies();
}
