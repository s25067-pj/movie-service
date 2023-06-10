package com.example.movieservice;

import com.example.movieservice.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Movie save(Movie movie) {
        movie.setAvailable(false);
        return movieRepository.save(movie);
    }
}
