package com.example.moviewatchlist.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return " Welcome to Movie Watchlist Backend Application";
    }
}


//package com.example.moviewatchlist.controller;
//
//import com.example.moviewatchlist.model.Movie;
//import com.example.moviewatchlist.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@RestController
//public class HomeController {
//
//    @Autowired
//    private MovieService movieService;
//
//    @GetMapping("/")
//    public String home() {
//        return "Welcome to Movie Watchlist Backend Application";
//    }
//
//    @GetMapping("/dashboard")
//    public Map<String, Object> dashboard() {
//        List<Movie> movies = movieService.findAllMovies();
//
//        Map<Integer, Long> ratingCount = movies.stream()
//                .collect(Collectors.groupingBy(
//                        m -> (int) m.getRating(),
//                        Collectors.counting()
//                ));
//
//        long watchedCount = movies.stream()
//                .filter(Movie::isWatched)
//                .count();
//
//        double averageRating = movies.stream()
//                .mapToDouble(Movie::getRating)
//                .average()
//                .orElse(0.0);
//
//        List<Movie> topRated = movies.stream()
//                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
//                .limit(3)
//                .collect(Collectors.toList());
//
//        Map<String, Object> dashboard = new LinkedHashMap<>();
//        dashboard.put("totalMovies", movies.size());
//        dashboard.put("watchedMovies", watchedCount);
//        dashboard.put("ratingDistribution", ratingCount);
//        dashboard.put("averageRating", String.format("%.2f", averageRating));
//        dashboard.put("topRatedMovies", topRated);
//
//        return dashboard;
//    }
//}
