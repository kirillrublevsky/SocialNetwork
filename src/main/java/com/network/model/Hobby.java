package com.network.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable{

    @Id
    @Column(name = "hobby_id")
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hobbies")
    private Set<Contact> contacts;

    public Hobby() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

        Hobby hobby = (Hobby) o;

        if (id != hobby.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
