package com.network.dao;

import com.network.model.Contact;
import com.network.model.Hobby;

import java.util.Set;

public interface HobbyDao {

    void addHobby(Hobby hobby);
    Set<Contact> getAllContactsWithHobby(Hobby hobby);
    void addHobbyToContact(Hobby hobby, Contact contact);

    Set<Hobby> getAllHobbies();
}
