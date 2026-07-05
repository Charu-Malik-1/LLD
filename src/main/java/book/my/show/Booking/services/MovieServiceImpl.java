package book.my.show.Booking.services;

import book.my.show.Booking.model.Movie;
import book.my.show.Booking.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import book.my.show.Booking.services.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

    public MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieById(long id) {
        return movieRepository.findById(id);
    }
}
