package com.example.cinemahe.view_controller;

import com.example.cinemahe.model.CaheMovie;
import com.example.cinemahe.repository.CaheMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for displaying the home page (main page, index or landing page.
 */
@Controller
public class HomePageController {

    private final CaheMovieRepository movieRepository;

    @Autowired
    public HomePageController(CaheMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping({"/", "/index", "/home"})
    public String getHomePage(final Model model) {
        final List<CaheMovie> moviesWithShortDescription = movieRepository.findAll(Pageable.ofSize(3)).stream()
                .peek(m -> m.setDescription(m.getDescription().substring(0, 200) + "..."))
                .collect(Collectors.toList());
        model.addAttribute("movies", moviesWithShortDescription);

        return "home";
    }
}
