package com.example.moviewatchlist.controller;

import com.example.moviewatchlist.model.Movie;
import com.example.moviewatchlist.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private MovieService service;

    @Test
    void testGetMoviesAboveRating() throws Exception {
        Movie movie = new Movie(1L, "Inception", "2010", "Sci-Fi");
        movie.setRating(8.8);
        Mockito.when(service.findMoviesAboveRating(8.0)).thenReturn(List.of(movie));

        mockMvc.perform(get("/movies/rating/8.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Inception"));
    }
}
