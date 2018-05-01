package com.galvanize.restaurants.controllers;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/restaurants")
public class ResaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @PostMapping
    public Restaurant saveRestaurant(@RequestBody  Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }
}
