package com.example.cinemahe.rest_controller;

import com.example.cinemahe.model.CaheDirector;
import com.example.cinemahe.repository.CaheDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1/director")
public class CaheDirectorRestController
{
    @Autowired
    private CaheDirectorRepository caheDirectorRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheDirector> getAll()
    {
        return caheDirectorRepository.findAll();
    }
}
