package com.example.Cinemaxx.service;

import com.example.Cinemaxx.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    Genre create(Genre genre);

    List<Genre> listAll();

    Optional<Genre> findById(Long id);
}
