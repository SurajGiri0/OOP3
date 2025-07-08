package com.example.moviewatchlist.service;

import com.example.moviewatchlist.model.Movie;
import com.example.moviewatchlist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    // Example of Streams API explicitly implemented
    public List<Movie> findMoviesAboveRating(double minRating) {
        return repository.findAll().stream()
                .filter(movie -> movie.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }
}
