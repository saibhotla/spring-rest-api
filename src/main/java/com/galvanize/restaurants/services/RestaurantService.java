package com.galvanize.restaurants.services;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RestaurantService {

    static List<Restaurant> restaurants = new ArrayList<>();

    public List<Restaurant> getAll() {
        return restaurants;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        int id = restaurants.stream()
                .map(Restaurant::getId)
                .reduce(0, Math::max) + 1;
        restaurant.setId(id);
        restaurants.add(restaurant);
        return restaurant;
    }
}
