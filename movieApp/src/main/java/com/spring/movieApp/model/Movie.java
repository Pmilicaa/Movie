package com.spring.movieApp.model;

import java.util.List;

public class Movie {
    private Long id;
    private String name;
    private String director;
    private String writers;
    private List<Genre> genre;
    private List<String> actors;

    public Movie(Long id, String name, String director, String writers, List<Genre> genre, List<String> actors) {
        super();
        this.id = id;
        this.name = name;
        this.director = director;
        this.writers = writers;
        this.genre = genre;
        this.actors = actors;
    }

    public Movie() {
        super();
    }

    public List<Genre> getGenre() {
        return genre;
    }
    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getWriters() {
        return writers;
    }
    public void setWriters(String writers) {
        this.writers = writers;
    }
    public List<String> getActors() {
        return actors;
    }
    public void setActors(List<String> actors) {
        this.actors = actors;
    }

}
