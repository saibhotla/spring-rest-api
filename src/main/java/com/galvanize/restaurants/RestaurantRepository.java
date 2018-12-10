package com.galvanize.restaurants;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
