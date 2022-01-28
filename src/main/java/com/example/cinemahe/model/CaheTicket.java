package com.example.cinemahe.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder(toBuilder = true)
public class CaheTicket
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime sellingDate;

    @ManyToOne
    private CaheSeance seance;

    @ManyToOne
    private CaheUser user;

    @ManyToOne
    private CaheSeat seat;
}
