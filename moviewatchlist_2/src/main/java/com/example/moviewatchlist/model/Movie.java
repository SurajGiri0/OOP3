package com.example.moviewatchlist.model;

import jakarta.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String genre;
    private double rating;

    public Movie() {}

    public Movie(Long id, String title, String year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }


    // getters and setters explicitly defined
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

//    private boolean watched = false;
//
//    public boolean isWatched() {
//        return watched;
//    }
//
//    public void setWatched(boolean watched) {
//        this.watched = watched;
//    }

}

