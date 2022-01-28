package com.example.cinemahe.service;

import com.example.cinemahe.CaheTicketRequestForm;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.model.CaheSeat;
import com.example.cinemahe.model.CaheTicket;
import com.example.cinemahe.repository.CaheSeanceRepository;
import com.example.cinemahe.repository.CaheSeatRepository;
import com.example.cinemahe.repository.CaheTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class CaheTicketService
{
    private final CaheTicketRepository ticketRepository;
    private final CaheSeanceRepository seanceRepository;
    private final CaheSeatRepository seatRepository;

    @Autowired
    public CaheTicketService(final CaheTicketRepository ticketRepository,
                             final CaheSeanceRepository seanceRepository,
                             final CaheSeatRepository seatRepository)
    {
        this.ticketRepository = ticketRepository;
        this.seanceRepository = seanceRepository;
        this.seatRepository = seatRepository;
    }

    public Iterable<CaheTicket> buyTicket(final CaheTicketRequestForm form)
    {
        final CaheSeance seance = seanceRepository.findById(form.getSeanceId())
                .orElseThrow(() -> new IllegalArgumentException("No such seance."));
        final Iterable<CaheSeat> seats = seatRepository.findAllById(form.getSeatId());

        final List<CaheTicket> ticketsBought = new ArrayList<>();
        for (CaheSeat seat : seats)
        {
            final CaheTicket ticket = CaheTicket.builder()
                    .seance(seance)
                    .sellingDate(now())
                    .user(null)
                    .seat(seat)
                    .build();
            ticketsBought.add(ticket);
        }
        return ticketRepository.saveAll(ticketsBought);
    }
}
