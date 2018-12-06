package com.galvanize.restaurants;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepository {

    final List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public Restaurant save(Restaurant restaurant){

        if(restaurant.getName() ==null){
            return null;
        }

        if(restaurant.getName().isEmpty()){
            return null;
        }

        restaurant.setId(restaurants.size() + 1);
        restaurants.add(restaurant);

        return restaurant;
    }

    public List<Restaurant> list(){
        return restaurants;
    }

    public void deleteAll() {
        restaurants.clear();
    }
}
