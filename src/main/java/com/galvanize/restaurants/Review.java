package com.galvanize.restaurants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
final class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @SequenceGenerator(name="review_generator", sequenceName = "review_sequence", allocationSize=1)
    private Long id;
    private String text;

    public Review(final Long id, String text) {
        this.id = id;
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
