package com.galvanize.restaurants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
public class Restaurant {
    public Restaurant(final String name){
        this.name = name;
    }

    public Restaurant(){
        this(null);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_generator")
    @SequenceGenerator(name="restaurant_generator", sequenceName = "restaurant_sequence", allocationSize=1)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Review> getReviews(){

       /* return Arrays.asList(new HashMap<String,Object>(){
            {
                put("id", 1);
                put("text", "Text");

            }
        },
        new HashMap<String,Object>(){
            {
                put("id", 7);
                put("text", "ELMO");

            }
        });*/
       reviews.add(new Review(1L,"Text"));

       return reviews;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();



}
