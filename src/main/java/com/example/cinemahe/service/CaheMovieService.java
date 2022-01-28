package com.example.cinemahe.service;

import com.example.cinemahe.model.CaheMovie;
import com.example.cinemahe.repository.CaheMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaheMovieService {

    private final CaheMovieRepository movieRepository;

    @Autowired
    public CaheMovieService(CaheMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<CaheMovie> getMovies(final int numberOfMovies) {

        return movieRepository.findAll(Pageable.ofSize(numberOfMovies)).stream().toList();
    }

    public List<CaheMovie> getAllMoviesWithTrimmedDescription() {
        final int minDescriptionLength = movieRepository.findAll(Pageable.ofSize(3)).stream()
                .map(CaheMovie::getDescription)
                .map(String::length)
                .mapToInt(i -> i)
                .min()
                .orElse(100);

        return movieRepository.findAll().stream()
                .peek(m -> m.setDescription(m.getDescription().substring(0, minDescriptionLength) + "..."))
                .toList();

    }
}
