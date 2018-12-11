package com.galvanize.restaurants;

import com.galvanize.restaurants.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
final class ReviewController {

    @GetMapping("/1")
    public String getReviews(){
        return "[]";
    }
}
