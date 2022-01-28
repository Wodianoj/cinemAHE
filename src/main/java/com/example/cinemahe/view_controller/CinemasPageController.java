package com.example.cinemahe.view_controller;

import com.example.cinemahe.repository.CaheCinemaRepository;
import com.example.cinemahe.utils.CahePrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This view controller is responsible for displaying the page presenting
 * all the cinemas owned by the CinemAHE company.
 */
@Controller
public class CinemasPageController
{
    private final CaheCinemaRepository cinemaRepository;

    @Autowired
    public CinemasPageController(CaheCinemaRepository cinemaRepository)
    {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")
    public String contact(Model model)
    {
        model.addAttribute("cinemas", cinemaRepository.findAll());

        return "cinemas";
    }
}
