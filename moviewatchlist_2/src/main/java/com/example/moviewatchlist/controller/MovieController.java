package com.example.moviewatchlist.controller;

import com.example.moviewatchlist.model.Movie;
import com.example.moviewatchlist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public List<Movie> getAllMovies() {
        return service.findAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovie(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
    }

    // new endpoint using stream clearly
    @GetMapping("/rating/{minRating}")
    public List<Movie> moviesAboveRating(@PathVariable double minRating) {
        return service.findMoviesAboveRating(minRating);
    }
}
