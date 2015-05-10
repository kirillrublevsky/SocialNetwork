package com.network.dao;

import com.network.dao.entity.Contact;

import java.util.List;

public interface ContactDao {

    void addContact(Contact contact);
    void deleteContact(long contactId);
    List<Contact> getAllContacts();

    void addFriendship(long contactId, long friendId);
    void removeFriendship(long contactId, long friendId);
    List<Contact> getFriendsList(long contactId);

}
