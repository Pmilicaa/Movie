package com.spring.movieApp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="director")
    private String director;

    @Column(name="writers")
    private String writers;

    @ElementCollection(targetClass = Genre.class)
    @JoinTable(name = "tblGenre", joinColumns = @JoinColumn(name = "movieId"))
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Genre> genre;

    @Column(name="actors")
    private String actors;

    @Column(name="active")
    private boolean active;

    public Movie(Long id, String name, String director, String writers, List<Genre> genre, String actors, boolean active) {
        super();
        this.id = id;
        this.name = name;
        this.director = director;
        this.writers = writers;
        this.genre = genre;
        this.actors = actors;
        this.active = active;
    }

    public Movie(String name, String director, String writers, List<Genre> genre, String actors) {
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
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = true;}
}
