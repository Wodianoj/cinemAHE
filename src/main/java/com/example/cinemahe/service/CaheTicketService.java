package com.example.cinemahe.service;

import com.example.cinemahe.CaheTicketRequestForm;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.model.CaheTicket;
import com.example.cinemahe.repository.CaheSeanceRepository;
import com.example.cinemahe.repository.CaheTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CaheTicketService
{
    private final CaheTicketRepository ticketRepository;
    private final CaheSeanceRepository seanceRepository;

    @Autowired
    public CaheTicketService(CaheTicketRepository ticketRepository, CaheSeanceRepository seanceRepository)
    {
        this.ticketRepository = ticketRepository;
        this.seanceRepository = seanceRepository;
    }

    public CaheTicket buyTicket(final CaheTicketRequestForm form)
    {
        final CaheSeance seance = seanceRepository.findById(form.getSeanceId())
                .orElseThrow(() -> new IllegalArgumentException("No such seance."));
        final

        CaheTicket caheTicket = CaheTicket.builder()
                .seance(seance)
                .sellingDate(LocalDateTime.now())
                .user()
                .build();
    }
}
