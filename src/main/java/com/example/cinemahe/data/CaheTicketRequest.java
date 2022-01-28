package com.example.cinemahe.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class CaheTicketRequest
{
    private UUID uuid;

    private Long seanceId;

    private List<Long> seatIds;

    private LocalDateTime creationDate;
}
