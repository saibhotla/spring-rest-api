package com.galvanize.restaurants.controllers;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.models.Review;
import com.galvanize.restaurants.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/api/restaurants/{restaurantId}/reviews")
    public Review reviewAdd(@PathVariable int restaurantId, @RequestBody Review review) {
        if(review.getRestaurantId() != restaurantId) throw new RuntimeException("Restaurant id does not match route!");
        return reviewService.reviewAdd(review);
    }
}
