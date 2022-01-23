package com.example.cinemahe.controller;

import com.example.cinemahe.model.CaheGenre;
import com.example.cinemahe.repository.CaheGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/genre")
public class CaheGenreController
{
    @Autowired
    private CaheGenreRepository caheGenreRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheGenre> getAll()
    {
        return caheGenreRepository.findAll();
    }
}
