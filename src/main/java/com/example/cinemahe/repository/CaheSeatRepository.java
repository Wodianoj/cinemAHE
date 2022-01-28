package com.example.cinemahe.repository;

import com.example.cinemahe.model.CaheSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaheSeatRepository extends JpaRepository<CaheSeat, Long>
{
    List<CaheSeat> findByRoomId(final Long roomId);
}
