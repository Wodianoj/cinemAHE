package com.example.cinemahe.rest_controller;

import com.example.cinemahe.model.CaheTicket;
import com.example.cinemahe.repository.CaheTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/ticket")
public class CaheTicketRestController
{
    @Autowired
    private CaheTicketRepository caheTicketRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheTicket> getAll()
    {
        return caheTicketRepository.findAll();
    }
}
