package com.example.cinemahe.view_controller;

import com.example.cinemahe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketsPageController
{
    private final CaheMovieRepository movieRepository;
    private final CaheGenreRepository genreRepository;
    private final CaheCinemaRepository cinemaRepository;
    private final CaheRoomRepository roomRepository;
    private final CaheSeatRepository seatRepository;

    @Autowired
    public TicketsPageController(final CaheMovieRepository movieRepository,
                                 final CaheGenreRepository genreRepository,
                                 final CaheCinemaRepository cinemaRepository,
                                 final CaheRoomRepository roomRepository,
                                 final CaheSeatRepository seatRepository)
    {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
    }

    @GetMapping("/tickets")
    public String getMoviePage(Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("cinemas", cinemaRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("seats", seatRepository.findAll());

        return "tickets";
    }
}
