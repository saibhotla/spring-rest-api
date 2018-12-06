package com.galvanize.restaurants;

import java.util.Objects;

final class Restaurant {

    private int id;
    private String name;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant(){

    }

    public Restaurant(String name){
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
