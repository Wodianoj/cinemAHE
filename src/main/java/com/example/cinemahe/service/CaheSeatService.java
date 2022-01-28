package com.example.cinemahe.service;

import com.example.cinemahe.data.CaheSeatAvailabilityInfo;
import com.example.cinemahe.model.CaheSeance;
import com.example.cinemahe.model.CaheSeat;
import com.example.cinemahe.repository.CaheSeanceRepository;
import com.example.cinemahe.repository.CaheSeatRepository;
import com.example.cinemahe.repository.CaheTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaheSeatService
{
    private final CaheSeatRepository seatRepository;
    private final CaheSeanceRepository seanceRepository;
    private final CaheTicketRepository ticketRepository;

    @Autowired
    public CaheSeatService(final CaheSeatRepository seatRepository,
                           final CaheSeanceRepository seanceRepository,
                           final CaheTicketRepository ticketRepository)
    {
        this.seatRepository = seatRepository;
        this.seanceRepository = seanceRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<CaheSeatAvailabilityInfo> getAvailabilityInfoForSeance(final Long seanceId)
    {
        final CaheSeance seance = seanceRepository.findById(seanceId).orElseThrow(() -> new IllegalArgumentException("No such seance"));
        return seatRepository.findByRoomId(seance.getRoom().getId()).stream()
                .map(seat -> this.getSeatAvailabilityReport(seanceId, seat))
                .toList();
    }

    private CaheSeatAvailabilityInfo getSeatAvailabilityReport(final Long seanceId, final CaheSeat seat)
    {
        final boolean available = !ticketRepository.existsBySeatIdAndSeanceId(seat.getId(), seanceId);

        return CaheSeatAvailabilityInfo.builder()
                .seat(seat)
                .seanceId(seanceId)
                .available(available)
                .build();
    }
}
