package com.network.dao;

import com.network.model.Contact;

import java.util.List;
import java.util.Set;

public interface ContactDao {

    void addContact(Contact contact);
    void deleteContact(Contact contact);
//    void addFriendship(Contact contact, Contact friend);
//    void removeFriendship(Contact contact, Contact friend);
    List getAllContacts();
}
