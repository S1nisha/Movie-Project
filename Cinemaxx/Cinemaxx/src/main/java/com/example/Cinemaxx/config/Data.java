package com.example.Cinemaxx.config;

import com.example.Cinemaxx.entities.Genre;
import com.example.Cinemaxx.entities.Movie;
import com.example.Cinemaxx.entities.Projection;
import com.example.Cinemaxx.entities.Type;
import com.example.Cinemaxx.service.GenreService;
import com.example.Cinemaxx.service.MovieService;
import com.example.Cinemaxx.service.ProjectionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class Data {

    private final GenreService genreService;
    private final MovieService movieService;
    private final ProjectionService projectionService;

    public Data(GenreService genreService, MovieService movieService, ProjectionService projectionService) {
        this.genreService = genreService;
        this.movieService = movieService;
        this.projectionService = projectionService;
    }

    @PostConstruct
    public void init() {
        Genre actionGenre=new Genre("Action");
        Genre dramaGenre=new Genre("Drama");
        Genre adventureGenre=new Genre("Adventure");
        Genre comedyGenre=new Genre("Comedy");
        Genre horrorGenre=new Genre("Horror");
        Genre thrillerGenre=new Genre("Thriller");
        Genre romanceGenre=new Genre("Romance");
        Genre scifiGenre=new Genre("Sci-Fi");
        Genre animationGenre=new Genre("Animation");
        Genre musicalGenre=new Genre("Musical");
        Genre documentaryGenre=new Genre("Documentary");
        Genre fantasyGenre=new Genre("Fantasy");

        genreService.create(actionGenre);
        genreService.create(dramaGenre);
        genreService.create(adventureGenre);
        genreService.create(comedyGenre);
        genreService.create(horrorGenre);
        genreService.create(thrillerGenre);
        genreService.create(romanceGenre);
        genreService.create(scifiGenre);
        genreService.create(animationGenre);
        genreService.create(musicalGenre);
        genreService.create(documentaryGenre);
        genreService.create(fantasyGenre);

//        List<Genre> genres=null;
//        genres.add(adventureGenre);
//        genres.add(comedyGenre);

                    //problem sas genres
        List<Long> genres = new ArrayList<>();
        genres.add(adventureGenre.getId());
        genres.add(actionGenre.getId());
        genres.add(fantasyGenre.getId());

        List<Long> genres2 = new ArrayList<>();
        genres2.add(horrorGenre.getId());
        genres2.add(actionGenre.getId());
        genres2.add(fantasyGenre.getId());
        genres2.add(adventureGenre.getId());

//        Movie movie1=this.movieService.save("Image1","videoLink1",Type.TWO_D,"Title1","Director1",genres,LocalDate.of(1200,12,1),120,0,"description1");
//        Movie movie2=this.movieService.save("https://www.harborfieldslibrary.org/sites/default/files/styles/large/public/2023-10/Oppenheimer-2023-movie-poster.jpg","videoLink2",Type.THREE_D,"Openhaimer","Christopher Nolan",genres2,LocalDate.of(1200,12,1),179,0,"Bpdqjwoednqowdnwopefjopew");
//        Movie movie3=this.movieService.save("Image2","videoLink2",Type.THREE_D,"Openhaimer","Christopher Nolan",genres2,LocalDate.of(1200,12,1),179,0,"Bpdqjwoednqowdnwopefjopew");
//        Movie movie4=this.movieService.save("Image1","videoLink1",Type.TWO_D,"Title1","Director1",genres,LocalDate.of(1200,12,1),120,0,"description1");
//        Movie movie5=this.movieService.save("https://www.harborfieldslibrary.org/sites/default/files/styles/large/public/2023-10/Oppenheimer-2023-movie-poster.jpg","videoLink2",Type.THREE_D,"Openhaimer","Christopher Nolan",genres2,LocalDate.of(1200,12,1),179,0,"Bpdqjwoednqowdnwopefjopew");
//        Movie movie6=this.movieService.save("Image2","videoLink2",Type.THREE_D,"Openhaimer","Christopher Nolan",genres2,LocalDate.of(1200,12,1),179,0,"Bpdqjwoednqowdnwopefjopew");

        Movie inception = new Movie(
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg",
                "http://example.com/inception.mp4",
                Type.THREE_D,
                "Inception",
                "Christopher Nolan",
                Arrays.asList(actionGenre, adventureGenre,horrorGenre),
                LocalDate.of(2010, 7, 16),
                148,
                0,
                "A mind-bending thriller about dreams within dreams."
                );
        Movie batman = new Movie(
                "https://m.media-amazon.com/images/M/MV5BMmU5NGJlMzAtMGNmOC00YjJjLTgyMzUtNjAyYmE4Njg5YWMyXkEyXkFqcGc@._V1_.jpg",
                "http://example.com/inception.mp4",
                Type.THREE_D,
                "The Batman",
                "Matt Reeves",
                Arrays.asList(actionGenre, adventureGenre,horrorGenre),
                LocalDate.of(2010, 7, 16),
                148,
                0,
                "A reclusive billionaire who obsessively protects Gotham City as a masked vigilante to cope with his traumatic past."
        );
        Movie movie2 = new Movie(
                "https://m.media-amazon.com/images/M/MV5BNTA5ZWMwNmYtNWI1ZS00NDRlLTkxNzktMzdhZDU2ZDhjNDJmXkEyXkFqcGc@._V1_.jpg",
                "http://example.com/inception.mp4",
                Type.TWO_D,
                "Scott Pilgrim vs The World",
                "Edgar Wright",
                Arrays.asList(actionGenre, adventureGenre, romanceGenre),
                LocalDate.of(2010, 7, 16),
                148,
                0,
                "In a magically realistic version of Toronto, a young man must defeat his new girlfriend's seven evil exes one by one in order to win her heart."
        );
        this.movieService.save(inception);
        this.movieService.save(movie2);
        this.movieService.save(batman);

        Projection projection1 = new Projection(inception,
                LocalDate.of(2010,7,16),
                LocalTime.of(12,10),
                1);
        Projection projection2 = new Projection(batman,
                LocalDate.of(2011,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection4 = new Projection(batman,
                LocalDate.of(2012,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection5 = new Projection(batman,
                LocalDate.of(2013,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection6 = new Projection(batman,
                LocalDate.of(2014,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection7 = new Projection(batman,
                LocalDate.of(2012,8,16),
                LocalTime.of(20,00),
                2);
        Projection projection8 = new Projection(batman,
                LocalDate.of(2013,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection9 = new Projection(batman,
                LocalDate.of(2014,7,16),
                LocalTime.of(20,00),
                2);
        Projection projection3 = new Projection(movie2,
                LocalDate.of(2012,7,16),
                LocalTime.now(),
                3);


        this.projectionService.create(projection1);
        this.projectionService.create(projection2);
        this.projectionService.create(projection3);
        this.projectionService.create(projection4);
        this.projectionService.create(projection5);
        this.projectionService.create(projection6);
        this.projectionService.create(projection7);
        this.projectionService.create(projection8);
        this.projectionService.create(projection9);





        //LocalDate localDate=LocalDate.of(2024,7,26);
        LocalDate localDate=LocalDate.now();

        LocalTime localTime= LocalTime.of(20,0);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localTime.getHour());
       // Projection projection=this.projectionService.create(movie1,localDate,localTime,1);

    }


}
