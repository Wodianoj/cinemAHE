package com.example.cinemahe.view_controller;

import com.example.cinemahe.service.CaheMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaheMoviesPageController
{

    private final CaheMovieService movieService;

    @Autowired
    public CaheMoviesPageController(CaheMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getMoviePage(Model model) {

        model.addAttribute("movies", movieService.getAllMoviesWithTrimmedDescription());

        return "movies";
    }
}
