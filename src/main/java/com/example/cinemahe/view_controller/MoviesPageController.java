package com.example.cinemahe.view_controller;

import com.example.cinemahe.repository.CaheGenreRepository;
import com.example.cinemahe.repository.CaheMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoviesPageController
{
    private final CaheMovieRepository movieRepository;
    private final CaheGenreRepository genreRepository;

    @Autowired
    public MoviesPageController(CaheMovieRepository movieRepository, CaheGenreRepository genreRepository)
    {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/movies")
    public String getMoviePage(Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());

        return "movies";
    }
}
