package com.example.Cinemaxx.service.impl;

import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Projection;
import com.example.Cinemaxx.repository.ProjectionRepository;
import com.example.Cinemaxx.service.ProjectionService;
import com.example.Cinemaxx.service.impl.exceptions.InvalidProjectionIdException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    @Override
    public Projection findById(Long id) {
        return this.projectionRepository.findById(id).orElseThrow(InvalidProjectionIdException::new);
    }

    @Override
    public List<Projection> listAll() {
        return this.projectionRepository.findAll();
    }

    @Override
    public List<Projection> filterByDate(LocalDate projectionDate) {
            if(projectionDate!=null) {
                return this.projectionRepository.findProjectionsByProjectionDateIsAfter(projectionDate);
            }
            else {
                return this.projectionRepository.findAll();
            }
    }

    //Da li treba ovoj uopste
    @Override
    public List<Projection> filterByMovie(Movie movie) {
        if(movie!=null) {
            return this.projectionRepository.findProjectionsByMovie(movie);
        }
        return this.projectionRepository.findAll();
    }

    @Override
    public List<Projection> filterByMovieAndDate(Movie movie, LocalDate projectionDate) {
        if(movie!=null && projectionDate!=null) {
            return this.projectionRepository.findProjectionsByMovieAndAndProjectionDateIsAfter(movie, projectionDate);
        } else if (movie!=null && projectionDate==null) {
            return this.projectionRepository.findProjectionsByMovie(movie);
        }
        if(movie==null && projectionDate!=null) {
            return this.projectionRepository.findProjectionsByProjectionDateIsAfter(projectionDate);
        }
        return this.projectionRepository.findAll();
    }

    @Override
    public Projection create(Projection projection) {
        //Projection projection1=new Projection(movie,projectionDate,projectionTime,projectionRoom);
        return this.projectionRepository.save(projection);
    }

    @Override
    public Projection edit(Long id, Movie movie, LocalDate projectionDate, LocalTime projectionTime, Integer projectionRoom) {
        Projection projection1=this.projectionRepository.findById(id).orElseThrow(InvalidProjectionIdException::new);
        projection1.setMovie(movie);
        projection1.setProjectionDate(projectionDate);
        projection1.setProjectionTime(projectionTime);
        projection1.setProjectionRoom(projectionRoom);
        return this.projectionRepository.save(projection1);
    }

    @Override
    public Projection delete(Long id) {
        Projection projection1=this.projectionRepository.findById(id).orElseThrow(InvalidProjectionIdException::new);
        this.projectionRepository.delete(projection1);
        return projection1;
    }
}
