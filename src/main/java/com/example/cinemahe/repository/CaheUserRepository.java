package com.example.cinemahe.repository;

import com.example.cinemahe.model.CaheUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaheUserRepository extends JpaRepository<CaheUser, Long>
{
    CaheUser findByMail(final String mail);
}
