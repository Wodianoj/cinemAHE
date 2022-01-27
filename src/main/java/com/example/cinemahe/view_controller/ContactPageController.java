package com.example.cinemahe.view_controller;

import com.example.cinemahe.repository.CaheCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactPageController
{
    private final CaheCinemaRepository cinemaRepository;

    @Autowired
    public ContactPageController(CaheCinemaRepository cinemaRepository)
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
