package com.network.model;

import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<Hobby> hobbies;
    private Set<Place> places;
    private Set<Contact> friends;

    public Contact() {}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public void setFriends(Set<Contact> friends) {
        this.friends = friends;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Set<Hobby> getHobbies() {
        if(hobbies == null){
            hobbies = new HashSet<Hobby>();
        }
        return hobbies;
    }

    public Set<Place> getPlaces() {
        if(places == null){
            places = new HashSet<Place>();
        }
        return places;
    }

    public Set<Contact> getFriends() {
        if(friends == null){
            friends = new HashSet<Contact>();
        }
        return friends;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }


}
