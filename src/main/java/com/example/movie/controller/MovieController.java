package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService ms;

    @GetMapping("/api/movies")
    public List<MovieDTO> selectAllMovies() {
        return ms.selectAllMovies();
    }

    @GetMapping("/api/movie/{movieCd}")
    public MovieDTO selectMovieDetailByMovieCode(@PathVariable int movieCd) {
        return ms.selectMovieDetailByMovieCode(movieCd);
    }
}


