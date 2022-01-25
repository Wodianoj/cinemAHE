package com.example.cinemahe.controller;

import com.example.cinemahe.model.CaheSeat;
import com.example.cinemahe.repository.CaheSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/seat")
public class CaheSeatController
{
    @Autowired
    private CaheSeatRepository caheSeatRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheSeat> getAll()
    {
        return caheSeatRepository.findAll();
    }
}
