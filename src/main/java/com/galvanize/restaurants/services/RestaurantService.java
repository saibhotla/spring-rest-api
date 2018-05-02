package com.galvanize.restaurants.services;

import com.galvanize.restaurants.models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    static List<Restaurant> restaurants = new ArrayList<>();

    public List<Restaurant> getAll() {
        return restaurants;
    }

    public Restaurant restaurantCreate(Restaurant restaurant) {
        int id = restaurants.stream()
                .map(Restaurant::getId)
                .reduce(0, Math::max) + 1;
        restaurant.setId(id);
        restaurants.add(restaurant);
        return restaurant;
    }

    public Restaurant restaurantUpdate(Restaurant restaurant) {
        for(int i = 0; i < restaurants.size(); i++) {
            Restaurant existing = restaurants.get(i);
            if(existing.getId() != restaurant.getId()) continue;
            restaurants.set(i, restaurant);
            return restaurant;
        }
        throw new RuntimeException("Restaurant not found with id=" + restaurant.getId());
    }
}
