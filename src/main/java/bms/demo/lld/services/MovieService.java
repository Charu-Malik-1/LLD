package bms.demo.lld.services;

import bms.demo.lld.models.Booking;
import bms.demo.lld.models.Movie;
import bms.demo.lld.models.Theater;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class MovieService {
    private Map<String, Movie> movingNameMapping;

    public MovieService() {
        movingNameMapping = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movingNameMapping.put(movie.getName(), movie);
    }

    public void removeMovie(Movie movie) {
        movingNameMapping.remove(movie.getName());
    }

    public Movie searchMovie(String name) {
        return null;
    }

    public Movie searchMovieByName(String name) {
        if (movingNameMapping.containsKey(name))
            return movingNameMapping.get(name);
        return null;
    }

    /** case-insensitive, partial-match search */
    public List<Movie> searchMoviesByNameContains(String query) {
        String q = query.toLowerCase();
        List<Movie> result = new ArrayList<>();
        for(Map.Entry<String,Movie> e: movingNameMapping.entrySet()){
            String name=e.getValue().getName();
            if (name.toLowerCase().contains(q)) {
                result.add(e.getValue());
            }
        }
       return result;
    }

//    public List<Movie> getAllMovies() {
//        return this.movies;
//    }

//    public void print(Movie movie) {
//        System.out.println(movie.id() + " " + movie.getName());
//    }
}
