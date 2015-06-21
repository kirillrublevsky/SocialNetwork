package com.network.dao.entity;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @Column(name = "contact_id")
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthDate;

    @ManyToMany
    @JoinTable(name="contact_hobby",
            joinColumns = @JoinColumn(name="contact_id"),
            inverseJoinColumns = @JoinColumn(name="hobby_id"))
    private Set<Hobby> hobbies;

    @ManyToMany
    @JoinTable(name="contact_place",
            joinColumns = @JoinColumn(name="contact_id"),
            inverseJoinColumns = @JoinColumn(name="place_id"))
    private Set<Place> places;

    @ManyToMany
    @JoinTable(name="contact_friend",
            joinColumns = @JoinColumn(name="contact_id"),
            inverseJoinColumns = @JoinColumn(name="friend_id"))
    private Set<Contact> contacts;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<Contact> friends;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fromContact")
    private Set<Message> messages;

    public Contact() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
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

    public Set<Contact> getContacts() {
        if(contacts == null){
            contacts = new HashSet<Contact>();
        }
        return contacts;
    }

    public Set<Message> getMessages() {
        if(messages == null){
            messages = new HashSet<Message>();
        }
        return messages;    }

    private boolean isNull(Object object){
        return object != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return id == contact.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
