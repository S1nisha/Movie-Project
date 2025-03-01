package com.example.Cinemaxx.service;

import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Type;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {


    /**
     * Find movie by specific Id
     **/
    Movie findById(Long id);

    /**
     * List All
     **/
    List<Movie> listAll();

    /**
     * Filter By Genre
     **/
    List<Movie> filterByGenre(Genre genre);

    List<Movie> filterByType(Type type);

    List<Movie> filterByTitle(String title);

    /**
     * Save Method for saving a movie
     **/
    //Movie save(String image, String videoLink, Type type, String title, String director, List<Long> genres, LocalDate releaseDate, Integer runtime, Integer likes, String description);

    Movie save(Movie movie);
    /**
     * EDIT method for editing info about a movie
     **/
    Movie edit(Long id,String image, String videoLink, Type type, String title, String director, List<Long> genres, LocalDate releaseDate, Integer runtime, Integer likes, String description);

    /**
     * DELETE method for deleta movie
     **/
    Movie delete(Long id);

    /**
     * LIKE method for deleta movie
     **/
    Movie like(Long id);
}
