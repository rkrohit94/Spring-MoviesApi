package com.allstate.controllers;

import com.allstate.entities.Movie;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by localadmin on 16/01/17.
 */

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Movie create(@RequestBody Movie movie){
        return this.movieService.create(movie);
    };

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Movie> listMovies(){
        return this.movieService.listMovies();
    };

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Movie findOneMovie(@PathVariable int id){
        return this.movieService.findById(id);
    };
    public void update(){};

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        this.movieService.deleteMovie(id);
    };

}
