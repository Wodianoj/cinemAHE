package com.example.cinemahe.repository;

import com.example.cinemahe.model.CaheMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaheMovieRepository extends JpaRepository<CaheMovie, Long> {

    @Query("SELECT cm.id FROM CaheMovie cm")
    List<Long> findAllIds();
}
