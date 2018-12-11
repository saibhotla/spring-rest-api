package com.galvanize.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
final class ReviewController {

    @Autowired
    RestaurantRepository repository;
    @PostMapping("/{id}/reviews/new")
    public Restaurant addReview(@PathParam("id") final long id, @RequestBody Review review){
        Optional<Restaurant> restaurant = repository.findById(id);
        restaurant.get().getReviews().add(review);
        return restaurant.get();
    }

    @GetMapping("/{id}/reviews")
    public Restaurant getReviews(@PathParam("id") final long id){
        Optional<Restaurant> restaurant = repository.findById(id);
        return restaurant.get();
    }


}
