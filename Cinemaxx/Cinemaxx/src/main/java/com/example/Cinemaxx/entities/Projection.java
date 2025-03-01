package com.example.Cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;


    private LocalDate ProjectionDate;

    //research za LocalTime kako se koristi
    //A time without a time-zone in the ISO-8601 calendar system, such as 10:15:30.
    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(iso= DateTimeFormat.ISO.TIME)
    private LocalTime ProjectionTime;

    private Integer ProjectionRoom;

    public Projection(Movie movie, LocalDate projectionDate, LocalTime projectionTime, Integer projectionRoom) {
        this.movie = movie;
        ProjectionDate = projectionDate;
        ProjectionTime = projectionTime;
        ProjectionRoom = projectionRoom;
    }

    public Projection() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getProjectionDate() {
        return ProjectionDate;
    }

    public void setProjectionDate(LocalDate projectionDate) {
        ProjectionDate = projectionDate;
    }

    public LocalTime getProjectionTime() {
        return ProjectionTime;
    }

    public void setProjectionTime(LocalTime projectionTime) {
        ProjectionTime = projectionTime;
    }

    public Integer getProjectionRoom() {
        return ProjectionRoom;
    }

    public void setProjectionRoom(Integer projectionRoom) {
        ProjectionRoom = projectionRoom;
    }
}
