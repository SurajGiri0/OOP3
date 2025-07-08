package com.example.moviewatchlist.service;

import com.example.moviewatchlist.model.Movie;
import com.example.moviewatchlist.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Mock private MovieRepository repository;
    @InjectMocks private MovieService service;

    MovieServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Movie movie = new Movie(1L, "Inception", "2010", "Sci-Fi");
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        Optional<Movie> found = service.findById(1L);
        assertTrue(found.isPresent());
        assertEquals("Inception", found.get().getTitle());
    }

    @Test
    void testMoviesAboveRating() {
        Movie movie1 = new Movie(1L, "Movie A", "2020", "Action");
        movie1.setRating(7.5);
        Movie movie2 = new Movie(2L, "Movie B", "2021", "Drama");
        movie2.setRating(8.5);

        when(repository.findAll()).thenReturn(List.of(movie1, movie2));

        List<Movie> result = service.findMoviesAboveRating(8.0);
        assertEquals(1, result.size());
        assertEquals("Movie B", result.get(0).getTitle());
    }
}
