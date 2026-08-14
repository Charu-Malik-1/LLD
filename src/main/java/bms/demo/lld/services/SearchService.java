package bms.demo.lld.services;

import bms.demo.lld.models.Auditorium;
import bms.demo.lld.models.Movie;
import bms.demo.lld.models.Show;
import bms.demo.lld.models.Theater;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchService {

    private final MovieService movieService;


    public SearchService(MovieService movieService){
        this.movieService=movieService;
    }

    public List<Movie> searchMovieByName(String query){
        return movieService.searchMoviesByNameContains(query);
    }

    public Set<Movie> getMovieInTheater(Theater theater){
        Set<Movie> movies = new HashSet<>();
        for(Auditorium auditorium: theater.getAuditoriumMap().values()){
            for(Show show: auditorium.getShowMap().values()){
                movies.add(show.getMovie());
            }
        }
        return movies;
    }
}
