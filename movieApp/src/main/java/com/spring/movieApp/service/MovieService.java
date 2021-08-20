package com.spring.movieApp.service;

import com.spring.movieApp.model.Movie;
import com.spring.movieApp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovie(Long id){
       Movie movie = movieRepository.findById(id).orElseThrow(NullPointerException::new);
       return movie;
    }
    public List<Movie> getMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }
    public void logicalDeleteMovie(Movie movie){
        movie.setActive(false);
        movieRepository.save(movie);
        return;
    }
    public Movie saveMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }
}
