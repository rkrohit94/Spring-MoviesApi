package com.allstate.services;

import com.allstate.entities.Movie;
import com.allstate.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    public void setRepository(IMovieRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private IMovieRepository repository;


    public Movie create(Movie m){
        return  this.repository.save(m);
    }
    public Iterable<Movie> listMovies(){
        return repository.findAll();
    }

    public Movie findById(int id){
        return  this.repository.findOne(id);
    }

    public Movie findByTitle(String title){
        return this.repository.findByTitle(title);
    }

    public void deleteMovie(int id){
        this.repository.delete(id);
    }

    public Movie update(int id, Movie n){

        Movie result = this.repository.findOne(id);
        result.setTitle(n.getTitle());
        result.setWatched(n.isWatched());
        result.setRating(n.getRating());
        result.setReleased(n.getReleased());
        result.setCreated(n.getCreated());
        result.setUpdated(n.getUpdated());
        result.setLength(n.getLength());


        return this.repository.save(result);
    }


}
