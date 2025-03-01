package com.example.Cinemaxx.service.impl;


import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Type;
import com.example.Cinemaxx.repository.GenreRepository;
import com.example.Cinemaxx.repository.MovieRepository;
import com.example.Cinemaxx.service.MovieService;
import com.example.Cinemaxx.service.impl.exceptions.InvalidMovieIdException;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }


    @Override
    public Movie findById(@PathVariable Long id) {
        return this.movieRepository.findById(id).orElseThrow(InvalidMovieIdException::new);
    }

    @Override
    public List<Movie> listAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> filterByGenre(Genre genre) {
        if(genre!=null){
            return this.movieRepository.findMoviesByGenresContaining(genre);
        }
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> filterByType(Type type) {
        return this.movieRepository.findMoviesByType(type);
    }

    @Override
    public List<Movie> filterByTitle(String title) {
        if(title!=null){
            return this.movieRepository.findMoviesByTitleContaining(title);
        }
        return this.movieRepository.findAll();
    }

//    @Override
//    public Movie save(String image,
//                      String videoLink,
//                      Type type,
//                      String title,
//                      String director,
//                      List<Long> genres,
//                      LocalDate releaseDate,
//                      Integer runtime,
//                      Integer likes,
//                      String description) {
//
//            List<Genre> genres1=this.genreRepository.findAllById(genres);
//            Movie movie1=new Movie(image,videoLink,type,title,director,genres1,releaseDate,runtime,likes,description);
//
//            return this.movieRepository.save(movie1);
//    }


    @Override
    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie edit(Long id,
                      String image,
                      String videoLink,
                      Type type,
                      String title,
                      String director,
                      List<Long> genres,
                      LocalDate releaseDate,
                      Integer runtime,
                      Integer likes,
                      String description) {

            Movie movie1=this.movieRepository.findById(id).orElseThrow(InvalidMovieIdException::new);
            List<Genre> genres1=this.genreRepository.findAllById(genres);
            movie1.setImage(image);
            movie1.setVideoLink(videoLink);
            movie1.setType(type);
            movie1.setTitle(title);
            movie1.setDirector(director);
            movie1.setGenres(genres1);
            movie1.setReleaseDate(releaseDate);
            movie1.setRuntime(runtime);
            movie1.setLikes(likes);
            movie1.setDescription(description);
            return this.movieRepository.save(movie1);
    }

    @Override
    public Movie delete(Long id) {
        Movie movie1=this.movieRepository.findById(id).orElseThrow(InvalidMovieIdException::new);
        this.movieRepository.delete(movie1);
        return movie1;
    }

    @Override
    public Movie like(Long id) {
        Movie movie1=this.movieRepository.findById(id).orElseThrow(InvalidMovieIdException::new);
        movie1.setLikes(movie1.getLikes()+1);
        return this.movieRepository.save(movie1);
    }

}
