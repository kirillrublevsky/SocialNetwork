package com.network.model;

import org.joda.time.LocalDate;

import java.io.Serializable;

public class ContactDTO implements Serializable {

    private long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public ContactDTO() {}

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

    public long getId() {
        return id;
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

    private boolean isNull(Object object){
        return object != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDTO contact = (ContactDTO) o;

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
