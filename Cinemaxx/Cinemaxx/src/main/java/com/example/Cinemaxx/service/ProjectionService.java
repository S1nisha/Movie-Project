package com.example.Cinemaxx.service;

import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Projection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ProjectionService {

    Projection findById(Long id);

    List<Projection> listAll();

    List<Projection> filterByDate(LocalDate projectionDate);

    List<Projection> filterByMovie(Movie movie);

    List<Projection> filterByMovieAndDate(Movie movie, LocalDate projectionDate);

    Projection create(Projection projection);

    Projection edit(Long id,Movie movie, LocalDate projectionDate, LocalTime projectionTime, Integer projectionRoom);

    Projection delete(Long id);

    //Projection save(Projection projection);
}
