package com.example.cinemahe.controller;

import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.repository.CaheSeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/seance")
public class CaheSeanceController
{
    @Autowired
    private CaheSeanceRepository caheSeanceRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheSeance> getAll()
    {
        return caheSeanceRepository.findAll();
    }
}
