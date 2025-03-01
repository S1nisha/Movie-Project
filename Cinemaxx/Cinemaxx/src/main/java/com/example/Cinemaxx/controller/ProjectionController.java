package com.example.Cinemaxx.controller;

import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Projection;
import com.example.Cinemaxx.service.ProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping(path = {"/projections"})
public class ProjectionController {

        private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @GetMapping
    public ResponseEntity<List<Projection>> getProjections() {
        return new ResponseEntity<>(projectionService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{movie}")
    public ResponseEntity<List<Projection>> getProjectionsByMovie(@PathVariable Movie movie) {
        return new ResponseEntity<>(this.projectionService.filterByMovie(movie), HttpStatus.OK);
    }
}
