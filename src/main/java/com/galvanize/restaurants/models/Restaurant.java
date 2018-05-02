package com.galvanize.restaurants.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private int id;
    private String name;
    private List<Review> reviews = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(int id, String name, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getReviews(), that.getReviews());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getReviews());
    }
}
