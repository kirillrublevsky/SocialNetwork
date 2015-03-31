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
        if (!isNull(firstName)){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!isNull(lastName)){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (!isNull(birthDate)){
            throw new IllegalArgumentException();
        }
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

    private boolean isNull(Object object){
        return object != null;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (birthDate != null ? !birthDate.equals(contact.birthDate) : contact.birthDate != null) return false;
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (friends != null ? !friends.equals(contact.friends) : contact.friends != null) return false;
        if (hobbies != null ? !hobbies.equals(contact.hobbies) : contact.hobbies != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        if (places != null ? !places.equals(contact.places) : contact.places != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }
}
