package com.example.cinemahe;

import lombok.Data;

import java.util.List;

@Data
public class CaheTicketRequestForm {
    private Long seanceId;
    private List<Long> seatId;
}
