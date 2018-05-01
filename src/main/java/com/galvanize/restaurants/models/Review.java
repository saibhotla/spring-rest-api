package com.galvanize.restaurants.models;

import java.util.Objects;

public class Review {
    private int id;
    private String text;
    private int stars;

    public Review() {
    }

    public Review(int id, String text, int stars) {
        this.id = id;
        this.text = text;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getId() == review.getId() &&
                getStars() == review.getStars() &&
                Objects.equals(getText(), review.getText());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getText(), getStars());
    }
}
