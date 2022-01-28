package com.example.cinemahe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
public class CaheMovie
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String shortDescription;
    private String description;
    private String wideImage;
    private String thinImage;
    private Integer year;

    @ManyToOne
    private CaheGenre genre;

    @ManyToMany
    @JoinTable(
            name = "cahe_movie_director",
            joinColumns = { @JoinColumn(name = "id_movie") },
            inverseJoinColumns = { @JoinColumn(name = "id_director") }
    )
    private List<CaheDirector> directors;
}
