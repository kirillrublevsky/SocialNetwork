package com.network.dao;

import com.network.model.Contact;

import java.util.Set;

public class ContactDaoImpl implements ContactDao {

    private Set<Contact> contacts;

    public ContactDaoImpl() {}

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Set<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);

    }

    @Override
    public void addFriendship(Contact contact, Contact friend){
        contact.getFriends().add(friend);
        friend.getFriends().add(contact);
    }

    @Override
    public void removeFriendship(Contact contact, Contact friend){
        contact.getFriends().remove(friend);
        friend.getFriends().remove(contact);
    }

}
