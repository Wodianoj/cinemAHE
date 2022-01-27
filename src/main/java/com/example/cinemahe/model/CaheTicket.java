package com.example.cinemahe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
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
