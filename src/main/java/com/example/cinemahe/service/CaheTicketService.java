package com.example.cinemahe.service;

import com.example.cinemahe.data.CahePurchaseRequest;
import com.example.cinemahe.data.CahePurchaseSummary;
import com.example.cinemahe.data.CaheTicketRequest;
import com.example.cinemahe.form.CaheTicketRequestForm;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.model.CaheSeat;
import com.example.cinemahe.model.CaheTicket;
import com.example.cinemahe.repository.CaheSeanceRepository;
import com.example.cinemahe.repository.CaheSeatRepository;
import com.example.cinemahe.repository.CaheTicketRepository;
import com.example.cinemahe.utils.CahePrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class CaheTicketService
{
    private final CaheTicketRepository ticketRepository;
    private final CaheSeanceRepository seanceRepository;
    private final CaheSeatRepository seatRepository;
    private final CahePrincipalUtils principalUtils;
    private final CahePriceService priceService;

    @Autowired
    public CaheTicketService(final CaheTicketRepository ticketRepository,
                             final CaheSeanceRepository seanceRepository,
                             final CaheSeatRepository seatRepository,
                             final CahePrincipalUtils principalUtils,
                             final CahePriceService priceService)
    {
        this.ticketRepository = ticketRepository;
        this.seanceRepository = seanceRepository;
        this.seatRepository = seatRepository;
        this.principalUtils = principalUtils;
        this.priceService = priceService;
    }

    @Transactional
    public Iterable<CaheTicket> buyTicket(final String blik, final CaheTicketRequestForm form)
    {
        final List<CaheTicket> ticketsBought = generatesTicketForTheRequest(form);

        if (ticketsBought.size() != form.getSeatIds().size())
        {
            throw new IllegalArgumentException("Not all seats could be booked.");
        }
        if (!blik.equals("111111"))
        {
            throw new IllegalArgumentException("The BLIK code is incorrect: payment failed.");
        }
        return ticketRepository.saveAll(ticketsBought);
    }

    @Transactional
    public boolean isTicketRequestOk(final CaheTicketRequestForm form)
    {
        boolean isRequestOk = true;

        final CaheSeance seance = seanceRepository.findById(form.getSeanceId()).orElse(null);
        if (seance == null)
        {
            isRequestOk = false;
        }

        for (Long seatId : form.getSeatIds())
        {
            final CaheSeat seat = seatRepository.findById(seatId).orElse(null);
            if (seat == null)
            {
                isRequestOk = false;
            }             else if (this.isSeatOccupied(seat.getId(), form.getSeanceId()))
            {
                isRequestOk = false;
            }
        }
        return isRequestOk;
    }

    public CahePurchaseSummary generatePurchaseSummary(final CaheTicketRequestForm form)
    {
        final List<CaheTicket> tickets = generatesTicketForTheRequest(form);
        final BigDecimal totalPrice = priceService.getPrice().multiply(BigDecimal.valueOf(tickets.size()));

        return CahePurchaseSummary.builder()
                .tickets(tickets)
                .total(totalPrice)
                .count(tickets.size())
                .build();
    }

    private List<CaheTicket> generatesTicketForTheRequest(final CaheTicketRequestForm form)
    {
        final CaheSeance seance = seanceRepository.findById(form.getSeanceId())
                .orElseThrow(() -> new IllegalArgumentException("No such seance."));
        final Iterable<CaheSeat> seats = seatRepository.findAllById(form.getSeatIds());

        final List<CaheTicket> ticketsBought = new ArrayList<>();
        for (CaheSeat seat : seats)
        {
            if (this.isSeatOccupied(seat.getId(), form.getSeanceId()))
            {
                throw new IllegalArgumentException("This seat is already booked.");
            }
            final CaheTicket ticket = CaheTicket.builder()
                    .seance(seance)
                    .sellingDate(now())
                    .user(principalUtils.getPrincipal())
                    .seat(seat)
                    .build();
            ticketsBought.add(ticket);
        }
        return ticketsBought;
    }

    private boolean isSeatOccupied(final Long seatId, final Long seanceId)
    {
        return ticketRepository.existsBySeatIdAndSeanceId(seatId, seanceId);
    }
}
