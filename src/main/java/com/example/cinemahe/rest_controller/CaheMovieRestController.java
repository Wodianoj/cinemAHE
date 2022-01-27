package com.example.cinemahe.rest_controller;

import com.example.cinemahe.model.CaheMovie;
import com.example.cinemahe.repository.CaheMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/movie")
public class CaheMovieRestController
{
    @Autowired
    private CaheMovieRepository caheMovieRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheMovie> getAll()
    {
        return caheMovieRepository.findAll();
    }
}
