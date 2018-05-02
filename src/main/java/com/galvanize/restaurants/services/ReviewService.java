package com.galvanize.restaurants.services;

import com.galvanize.restaurants.models.Restaurant;
import com.galvanize.restaurants.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    RestaurantService restaurantService;

    public Review reviewAdd(Review review) {
        Restaurant restaurant = restaurantService.restaurants.stream()
                .filter(r -> r.getId() == review.getRestaurantId()).findFirst().get();
        int id = restaurant.getReviews().stream()
                .map(Review::getId)
                .reduce(0, Math::max) + 1;
        review.setId(id);
        restaurant.getReviews().add(review);
        return review;
    }
}
