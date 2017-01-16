package com.allstate.services;

import com.allstate.entities.Movie;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Lists;
import org.hibernate.annotations.SourceType;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class MovieServiceTest {
    @Autowired
    private MovieService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateMovie() throws Exception {

        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);
        assertEquals(2,after.getId());
        assertEquals(after.getTitle(), "The Matrix");
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotCreateMovieNoTitle() {

        Movie before = new Movie();
        Movie after = this.service.create(before);
        assertEquals(2,after.getId());
    }

    @Test
    public void shouldFindMovieById(){
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);
        Movie result = this.service.findById(2);
        assertEquals(after,result);
    }
    @Test
    public void shouldNotFindMovieById(){
        Movie result = this.service.findById(4);
        assertNull(result);
    }

    @Test
    public void shouldFindAllMovie(){
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);
        Iterable<Movie> result = this.service.listMovies();
        List list = Lists.newArrayList(result);
        assertEquals(list.size(), 2 );
        assertEquals(after,list.get(1));
    }

    @Test
    public void shouldFindMovieByTitle(){
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);
        Movie result = this.service.findByTitle("The Matrix");
        assertEquals(after,result);
    }

    @Test
    public void shouldNotFindMovieByTitle(){
        Movie before = new Movie();
        Movie result = this.service.findByTitle("The Matrix");
        assertNull(result);
    }

    @Test
    public void shouldDeleteMovieById(){
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);
        this.service.deleteMovie(2);
        Movie result = this.service.findByTitle("The Matrix");
        assertNull(result);
    }

    @Test
    public void shouldUpdateMovieById(){
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);

        Movie updated = new Movie();
        updated.setTitle("The Matrix: part two");
        Movie result= this.service.update(2,updated);

        assertEquals("The Matrix: part two",result.getTitle());
        assertEquals(1,result.getVersion());
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void shouldNotUpdateTheMovieIfNotPresent() {

        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.service.create(before);

        Movie updated = new Movie();
        updated.setTitle("The Matrix: part two");
        Movie result= this.service.update(4,updated);
    }
}