package com.example.cinemahe.controller;

import com.example.cinemahe.model.CaheCinema;
import com.example.cinemahe.repository.CaheCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/cinema")
public class CaheCinemaController
{
    @Autowired
    private CaheCinemaRepository caheCinemaRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheCinema> getAll()
    {
        return caheCinemaRepository.findAll();
    }
}
