package com.example.cinemahe.repository;

import com.example.cinemahe.model.CaheTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaheTicketRepository extends JpaRepository<CaheTicket, Long>
{
    boolean existsBySeatIdAndSeanceId(final Long seatId, final Long seanceId);
}
