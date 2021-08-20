package com.spring.movieApp.controllers;

import com.spring.movieApp.model.Movie;
import com.spring.movieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path="/movies/{id}")
    public @ResponseBody ResponseEntity<Movie> getMovie(@PathVariable("id") Long id){
        Movie movie = movieService.getMovie(id);
        if(movie == null){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }
    @GetMapping(path="/movies")
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.getMovies(),HttpStatus.OK);
    }
    @PostMapping(path="/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie newMovie = new Movie(movie.getName(), movie.getDirector(), movie.getWriters(),
                movie.getGenre(), movie.getActors());
        return new ResponseEntity<Movie>(movieService.saveMovie(newMovie), HttpStatus.OK);
    }
    @DeleteMapping(path="/movies/{id}")
    public ResponseEntity<Void> logicalDelMovie(@PathVariable("id") Long id){
        Movie movie = movieService.getMovie(id);
        if(movie == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        movieService.logicalDeleteMovie(movie);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
