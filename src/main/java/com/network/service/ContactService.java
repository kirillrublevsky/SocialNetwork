package com.network.service;

import com.network.dao.entity.Contact;
import com.network.model.ContactDTO;
import org.joda.time.LocalDate;

import java.util.List;

public interface ContactService {

    void createContact(String firstName, String lastName, LocalDate birthDate);
    void removeContact(long contactId);
    List<ContactDTO> getAllContacts();

    void addFriendship(long contactId, long friendId);
    void removeFriendship(long contactId, long friendId);
    List<ContactDTO> getFriendsList(long contactId);

    List<ContactDTO> convertListContactToListContactDTO(List<Contact> contactList);
}
