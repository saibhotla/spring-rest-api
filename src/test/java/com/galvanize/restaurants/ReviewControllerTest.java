package com.galvanize.restaurants;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantRepository repository;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Before
    public void beforeEach(){
        repository.deleteAll();
    }

    @After
    public void afterEach(){
        repository.deleteAll();
    }

    @Test
    public void returnEmptyReviewsForExistingRestaurant() throws Exception{

        //Setup
        final Restaurant expected = new Restaurant("Fred's Ribs");
        repository.save(expected);

        //Exercise
        final String actual = mockMvc.perform(get("/api/restaurants/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //Assert
        assertThat(actual, is("[]"));
    }

    @Test
    public void returnOneReviewForExistingRestaurant() throws Exception{

        //Setup
        final Restaurant expected = new Restaurant("Fred's Ribs");
        repository.save(expected);

        //Exercise
        final String actual = mockMvc.perform(get("/api/restaurants/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //Assert
        assertThat(actual, is("[]"));
    }
}
