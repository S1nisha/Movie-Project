package com.example.Cinemaxx.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import org.aspectj.lang.annotation.After;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //treba slika field da se dodade
    private String image;

    //treba video field da se dodade (trailer)
    private String videoLink;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String title;

    private String director;

    @ManyToMany
    private List<Genre> genres;

    @Future(message="Must be in the future")
    private LocalDate releaseDate;

    private Integer runtime;

    private Integer likes = 0;

    private String description;

    public Movie(String image, String videoLink, Type type, String title, String director, List<Genre> genres, LocalDate releaseDate, Integer runtime, Integer likes, String description) {
        this.image = image;
        this.videoLink = videoLink;
        this.type = type;
        this.title = title;
        this.director = director;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.likes = likes;
        this.description = description;
    }

    public Movie(String title, String image, String videoLink, String director, String description, Integer runtime, Integer likes, LocalDate releaseDate, Type type, List<Genre> genres) {
        this.title = title;
        this.image = image;
        this.videoLink = videoLink;
        this.director = director;
        this.description = description;
        this.runtime = runtime;
        this.likes = likes;
        this.releaseDate = releaseDate;
        this.type = type;
        this.genres = genres;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
