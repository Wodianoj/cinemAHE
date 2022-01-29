package com.example.cinemahe.service;

import com.example.cinemahe.form.CaheSeanceSearchForm;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.repository.CaheSeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaheSeanceService
{
    private final CaheSeanceRepository seanceRepository;

    @Autowired
    public CaheSeanceService(CaheSeanceRepository seanceRepository)
    {
        this.seanceRepository = seanceRepository;
    }

    public Iterable<CaheSeance> findAll()
    {
        return seanceRepository.findAll();
    }

    public List<CaheSeance> search(final CaheSeanceSearchForm searchForm)
    {
        return seanceRepository.search(searchForm).stream()
                .filter(s -> s.getMovie().getId().equals(searchForm.getMovieId()) || searchForm.getMovieId() == null)
                .filter(s -> s.getRoom().getCinema().getId().equals(searchForm.getCinemaId()) || searchForm.getCinemaId() == null)
                .toList();
    }
}
