package com.example.cinemahe.view_controller;

import com.example.cinemahe.repository.CaheCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This view controller is responsible for displaying the page providing contact data
 * for the CinemAHE company and particular cinemas.
 */
@Controller
public class CaheContactPageController
{
    private final CaheCinemaRepository cinemaRepository;

    @Autowired
    public CaheContactPageController(CaheCinemaRepository cinemaRepository)
    {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/contact")
    public String contact(Model model)
    {
        model.addAttribute("cinemas", cinemaRepository.findAll());
        return "contact";
    }
}
