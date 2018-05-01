package com.galvanize.restaurants.services;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantService {

    public static List<Restaurant> restaurants = Arrays.asList(
            new Restaurant(1, "Bob's Burgers", Arrays.asList(
                    new Review(1, "It's the best", 5)
            )),
            new Restaurant(2, "Los Tacos Burgers", new ArrayList<>())
    );

    public List<Restaurant> getAll() {
        return restaurants;
    }
}
