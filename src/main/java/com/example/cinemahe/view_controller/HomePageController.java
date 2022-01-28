package com.example.cinemahe.view_controller;

import com.example.cinemahe.service.CaheMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class is responsible for displaying the home page (main page, index or landing page.
 */
@Controller
public class HomePageController {

    private final CaheMovieService movieService;

    public HomePageController(CaheMovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping({"/", "/index", "/home"})
    public String getHomePage(final Model model)
    {
        model.addAttribute("movies", movieService.getMovies(3));

        return "home";
    }
}
