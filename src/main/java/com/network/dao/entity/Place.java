package com.network.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place implements Serializable{

    @Id
    @Column(name = "place_id")
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "places")
    private Set<Contact> contacts;

    public Place() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getDescription() {
        return description;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setTitle(String title) {
        if (!isNull(title)){
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public void setLongitude(double longitude) {
        if (longitude == 0){
            throw new IllegalArgumentException();
        }
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        if (latitude == 0){
            throw new IllegalArgumentException();
        }
        this.latitude = latitude;
    }

    public void setDescription(String description) {
        if (!isNull(description)){
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    private boolean isNull(Object object){
        return object != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (id != place.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
                '}';
    }
}
