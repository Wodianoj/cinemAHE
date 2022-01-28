package com.example.cinemahe.view_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class is responsible for displaying the home page (main page, index or landing page.
 */
@Controller
public class HomePageController {

    @GetMapping({"/", "/index", "/home"})
    public String getHomePage() {
        return "home";
    }
}
