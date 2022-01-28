package com.example.cinemahe.form;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class CaheTicketRequestForm
{
    private Long seanceId;

    private List<Long> seatIds;
}
