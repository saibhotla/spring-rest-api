package com.galvanize.restaurants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantRepository repository;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Before
    public void beforeEach(){
        repository.deleteAll();
    }

    //@After
    public void afterEach(){
        repository.deleteAll();
    }

    @Test
    public void getReturnsEmptyList() throws Exception{
        //Setup

        //Exercise
        final String actual = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //Assert
        assertThat(actual, is("[]"));
    }

    @Test
    public void listReturnsOneRestaurantFromRepository()throws Exception{
        //Setup
        final Restaurant expected = new Restaurant("Fred's Ribs");
        repository.save(expected);


        //Exercise
        final String content = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        final List<Restaurant> actual = OBJECT_MAPPER.readValue(content,new TypeReference<List<Restaurant>>(){});

        //Assert
        assertThat(actual, contains(expected));

    }

    @Test
    public void listReturnsMultipleRestaurantsFromRepository()throws Exception{
        //Setup
        final Restaurant ribs = new Restaurant("Fred's Ribs");
        final Restaurant mcDonalds = new Restaurant("McDonalds");

        repository.save(ribs);
        repository.save(mcDonalds);


        //Exercise
        final String content = mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        final List<Restaurant> actual = OBJECT_MAPPER.readValue(content,new TypeReference<List<Restaurant>>(){});


        //Assert
        assertThat(actual, contains(ribs,mcDonalds));

    }

}
