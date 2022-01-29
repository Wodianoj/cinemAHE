package com.example.cinemahe.rest_controller;

import com.example.cinemahe.data.CaheSeatAvailabilityInfo;
import com.example.cinemahe.form.CaheSeatSearchForm;
import com.example.cinemahe.model.CaheSeat;
import com.example.cinemahe.repository.CaheSeatRepository;
import com.example.cinemahe.service.CaheSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/seat")
public class CaheSeatRestController
{
    private final CaheSeatRepository caheSeatRepository;
    private final CaheSeatService seatService;

    @Autowired
    public CaheSeatRestController(CaheSeatRepository caheSeatRepository, CaheSeatService seatService)
    {
        this.caheSeatRepository = caheSeatRepository;
        this.seatService = seatService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheSeat> getAll()
    {
        return caheSeatRepository.findAll();
    }

    @PostMapping(path = "/search")
    @ResponseBody
    public List<CaheSeatAvailabilityInfo> search(@RequestBody final CaheSeatSearchForm searchForm)
    {
        return seatService.getAvailabilityInfoForSeance(searchForm);
    }
}
