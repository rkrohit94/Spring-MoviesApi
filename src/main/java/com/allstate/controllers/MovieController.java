package com.allstate.controllers;

import com.allstate.entities.Movie;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Movie findOneMovie(@RequestParam Map<String,String> query){
        return this.movieService.findByTitle(query.get("title"));
    };

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Movie update(@PathVariable int id , @RequestBody Movie movie){
        return this.movieService.update(id, movie);
    };

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        this.movieService.deleteMovie(id);
    };

}

