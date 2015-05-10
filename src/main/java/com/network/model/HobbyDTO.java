package com.network.model;

import java.io.Serializable;

public class HobbyDTO implements Serializable {

    private long id;

    private String title;
    private String description;

    public HobbyDTO() {}

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

        HobbyDTO hobby = (HobbyDTO) o;

        return id == hobby.id;

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
                '}';
    }
}
