package com.network.service;

import com.network.dao.*;
import com.network.model.Contact;
import com.network.model.Hobby;
import com.network.model.Place;
import org.joda.time.LocalDate;

import java.util.Set;

public class JavaContactServiceImpl implements JavaContactService {

    private ContactDao contactDao;
    private HobbyDao hobbyDao;
    private PlaceDao placeDao;

    public JavaContactServiceImpl() {}

    public ContactDao getContactDao() {
        return contactDao;
    }

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public PlaceDao getPlaceDao() {
        return placeDao;
    }
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public Contact createContact(String firstName, String lastName, LocalDate date) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(date);

        contactDao.addContact(contact);

        return contact;
    }

    @Override
    public void addHobby(Contact contact, String title, String description) {
        Hobby hobby = new Hobby();
        hobby.setTitle(title);
        hobby.setDescription(description);

        contact.getHobbies().add(hobby);
        hobbyDao.addHobby(hobby);
    }

    @Override
    public void addPlace(Contact contact, String title, String description, double longitude, double latitude) {
        Place place = new Place();
        place.setTitle(title);
        place.setDescription(description);
        place.setLatitude(latitude);
        place.setLongitude(longitude);

        contact.getPlaces().add(place);
        placeDao.addPlace(place);
    }

    @Override
    public void addFriendship(Contact contact, Contact friend) {
        contactDao.addFriendship(contact, friend);
    }

    @Override
    public Set<Contact> getFriendsList(Contact contact) {
        return contact.getFriends();
    }
}
