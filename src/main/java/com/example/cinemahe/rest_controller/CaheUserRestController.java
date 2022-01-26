package com.example.cinemahe.rest_controller;

import com.example.cinemahe.model.CaheUser;
import com.example.cinemahe.repository.CaheUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class CaheUserRestController
{
    @Autowired
    private CaheUserRepository caheUserRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheUser> getAll()
    {
        return caheUserRepository.findAll();
    }
}
