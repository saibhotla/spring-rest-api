package com.galvanize.restaurants;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    RestaurantRepository restaurantRepository;

    @After
    public void clearRepository(){
        restaurantRepository.deleteAll();
    }

    @Test
    public void listReturnsEmptyListOfRestaurantsWhenNullRestuarant() throws Exception {
        //Setup
        Restaurant restaurant = new Restaurant(null);
        restaurantRepository.save(restaurant);
        //Exercise
        final String responseString = mockMvc
                .perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<Restaurant> actual = OBJECT_MAPPER.readValue(responseString,
                new TypeReference<List<Restaurant>>(){});
        //Assert
        assertThat(actual.isEmpty(), is(true));
    }

    @Test
    public void returnsEmptyListofRestaurants() throws Exception{
        //Exercise
        final String  responseContent = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //Assert
        assertThat(responseContent, is("[]"));

    }

    @Test
    public void returnsOneRestaurant() throws Exception{

        Restaurant newRestaurant = new Restaurant(0, "KFC");

        restaurantRepository.save(newRestaurant);

        final String  responseContent = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Restaurant> actual = OBJECT_MAPPER.readValue(responseContent, new TypeReference<List<Restaurant>>(){});

        //Assert
        assertThat(actual, contains(newRestaurant));

    }

    @Test
    public void returnsMoreThenOneRestaurant() throws Exception{

        Restaurant kfc = new Restaurant(0, "KFC");
        Restaurant chipotle = new Restaurant(1,"chipotle");

        restaurantRepository.save(kfc);
        restaurantRepository.save(chipotle);

        final String  responseContent = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Restaurant> actual = OBJECT_MAPPER.readValue(responseContent, new TypeReference<List<Restaurant>>(){});

        //Assert
        assertThat(actual, contains(kfc,chipotle));

    }


}
