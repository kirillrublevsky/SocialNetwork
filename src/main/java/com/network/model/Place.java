package com.network.model;

public class Place {

    private String title;
    private double longitude;
    private double latitude;
    private String description;

    public Place() {}

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
    public String toString() {
        return "Place{" +
                "title='" + title + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (Double.compare(place.latitude, latitude) != 0) return false;
        if (Double.compare(place.longitude, longitude) != 0) return false;
        if (description != null ? !description.equals(place.description) : place.description != null) return false;
        if (title != null ? !title.equals(place.title) : place.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
