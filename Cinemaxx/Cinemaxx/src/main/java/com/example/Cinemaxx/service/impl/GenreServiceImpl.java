package com.example.Cinemaxx.service.impl;

import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.repository.GenreRepository;
import com.example.Cinemaxx.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre create(Genre genre) {
        return this.genreRepository.save(genre);
    }

    @Override
    public List<Genre> listAll() {
        return this.genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return this.genreRepository.findById(id);
    }
}
