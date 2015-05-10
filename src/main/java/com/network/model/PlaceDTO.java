package com.network.model;

import java.io.Serializable;

public class PlaceDTO implements Serializable {

    private long id;

    private String title;
    private String description;
    private double longitude;
    private double latitude;

    public PlaceDTO() {}

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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

        PlaceDTO place = (PlaceDTO) o;

        return id == place.id;

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
