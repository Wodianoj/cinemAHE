package com.example.cinemahe.rest_controller;

import com.example.cinemahe.form.CaheSeanceSearchForm;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.service.CaheSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/seance")
public class CaheSeanceRestController
{
    private CaheSeanceService seanceService;

    @Autowired
    public CaheSeanceRestController(final CaheSeanceService seanceService)
    {
        this.seanceService = seanceService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CaheSeance> getAll()
    {
        return seanceService.findAll();
    }

    @PostMapping(path = "/search")
    @ResponseBody
    public List<CaheSeance> search(@RequestBody CaheSeanceSearchForm searchForm)
    {
        return seanceService.search(searchForm);
    }
}
