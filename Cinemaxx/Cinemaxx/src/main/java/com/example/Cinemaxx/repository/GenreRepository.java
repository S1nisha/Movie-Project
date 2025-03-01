package com.example.Cinemaxx.repository;

import com.example.Cinemaxx.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllById(Genre genre);
}
