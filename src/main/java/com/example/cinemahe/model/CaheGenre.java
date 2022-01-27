package com.example.cinemahe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CaheGenre
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String genreName;
}
