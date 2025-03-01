package com.example.Cinemaxx.repository;

import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //flush??
    List<Movie> findMoviesByGenresContaining(Genre genre);

    List<Movie> findMoviesByType(Type type);

    @Query("select m from Movie m where m.title=?1")
    List<Movie> findMoviesByTitleContaining(String title);
}
