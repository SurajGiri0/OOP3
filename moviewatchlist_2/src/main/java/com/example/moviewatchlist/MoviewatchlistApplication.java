package com.example.moviewatchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class MoviewatchlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviewatchlistApplication.class, args);
    }

}
