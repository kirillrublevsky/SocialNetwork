package com.network.dao;

import com.network.model.Contact;
import com.network.model.Hobby;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HobbyDaoImpl implements HobbyDao {

    private Set<Hobby> hobbies;

    private ContactDao contactDao;

    public HobbyDaoImpl() {}

    public ContactDao getContactDao() {
        return contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    @Override
    public void addHobby(Hobby hobby) {
        hobbies.add(hobby);

    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        Set<Contact> contactSet = new HashSet<Contact>();
        Set<Contact> contacts = contactDao.getContacts();
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            Set<Hobby> hobbySet = contact.getHobbies();
            if(hobbySet.contains(hobby)){
                contactSet.add(contact);
            }
        }
        return contactSet;
    }

    @Override
    public void addHobbyToContact(Hobby hobby, Contact contact) {
        addHobby(hobby);
        contact.getHobbies().add(hobby);

    }


}
