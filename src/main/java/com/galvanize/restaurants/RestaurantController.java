package com.galvanize.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
final class RestaurantController {


    private final RestaurantRepository repository;

    @Autowired
    RestaurantController(final RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Restaurant> getRestaurants(){

        return repository.findAll();
    }

    @PostMapping
    public Restaurant addRestaurants(@RequestBody Restaurant newRestaurant){
        if (newRestaurant.getName().equals("")) {
            throw new RuntimeException();
        }

        return repository.save(newRestaurant);
    }

}
