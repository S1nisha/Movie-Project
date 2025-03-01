package com.example.Cinemaxx.controller;

import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Type;
import com.example.Cinemaxx.service.GenreService;
import com.example.Cinemaxx.service.MovieService;
import com.example.Cinemaxx.service.impl.GenreServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping(path = {"/movies"})
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService, GenreServiceImpl genreServiceImpl, GenreService genreService1) {
        this.movieService = movieService;
        this.genreService = genreService1;
    }

    @GetMapping("/types")
    public List<String> getTypes() {
        return Arrays.stream(Type.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(this.movieService.listAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id){
        return new ResponseEntity<>(this.movieService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = {"/delete/{id}"})
    public ResponseEntity<Movie> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.movieService.delete(id), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Genre>> getAllGenres() {
//        return new ResponseEntity<>(this.genreService.listAll(), HttpStatus.OK);
//    }

//    DA LI UOPSTE DA PRAVU SEARCH BAR U CONTROLLER
    @GetMapping(path = {"/","movies"})
    public ResponseEntity<List<Movie>> getMoviesByTitle(@RequestParam(required = false) String title) {
        List<Movie> movies=null;
        if(title != null){
             movies=this.movieService.filterByTitle(title);
        }
        else{
            movies=this.movieService.listAll();
        }
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @PostMapping(path = "/add-movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {

        Movie movie1 = new Movie(movie.getTitle(), movie.getImage(), movie.getVideoLink(),
                movie.getDirector(), movie.getDescription(), movie.getRuntime(),
                movie.getLikes(), movie.getReleaseDate(),movie.getType(), movie.getGenres());

        System.out.println(movie1);
        return new ResponseEntity<>(this.movieService.save(movie1), HttpStatus.CREATED);
    }

    @GetMapping(path="/movie/{id}")
    public ResponseEntity<Movie> detailsMovie(@PathVariable Long id){
        Movie movie1=this.movieService.findById(id);
        return new ResponseEntity<>(movie1,HttpStatus.OK);
    }

    @GetMapping(path = "/{genre}")
    public ResponseEntity<List<Movie>> filterByGenre(@PathVariable Genre genre) {
        return new ResponseEntity<>(this.movieService.filterByGenre(genre), HttpStatus.OK);
    }
}
