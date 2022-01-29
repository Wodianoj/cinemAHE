package com.example.cinemahe.rest_controller;

import com.example.cinemahe.model.CaheRoom;
import com.example.cinemahe.repository.CaheRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1/room")
public class CaheRoomRestController
{
    @Autowired
    private CaheRoomRepository caheRoomRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheRoom> getAll()
    {
        return caheRoomRepository.findAll();
    }
}
