package com.galvanize.restaurants.controllers;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ResaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/api/restaurants")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @PostMapping("/api/restaurants")
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.restaurantCreate(restaurant);
    }

    @PutMapping("/api/restaurants/{id}")
    public Restaurant restaurantUpdate(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        if(id != restaurant.getId()) throw new RuntimeException("Restaurant id does not match route!");
        return restaurantService.restaurantUpdate(restaurant);
    }
}
