package com.example.Cinemaxx.repository;


import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {


    @Query("select p from Projection p where p.ProjectionDate=?1")
    List<Projection> findProjectionsByProjectionDateIsAfter(LocalDate date);


    List<Projection> findProjectionsByMovie(Movie movie);

    @Query("select p from Projection p join p.movie m where m = :movie and p.ProjectionDate > :date")
    List<Projection> findProjectionsByMovieAndAndProjectionDateIsAfter(@Param("movie") Movie movie,@Param("date") LocalDate date);
}
