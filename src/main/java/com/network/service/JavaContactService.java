package com.network.service;

import com.network.model.Contact;
import org.joda.time.LocalDate;

import java.util.Set;

public interface JavaContactService {

    Contact createContact(String firstName, String lastName, LocalDate date);
    void addHobby(Contact contact, String title, String description);
    void addPlace(Contact contact, String title, String description, double longitude, double latitude);
    void addFriendship(Contact contact, Contact friend);
    Set<Contact> getFriendsList(Contact contact);
}
