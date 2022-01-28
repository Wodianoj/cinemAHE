package com.example.cinemahe.utils;

import com.example.cinemahe.model.CaheUser;
import com.example.cinemahe.repository.CaheUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CahePrincipalUtils
{
    private final CaheUserRepository caheUserRepository;

    @Autowired
    public CahePrincipalUtils(CaheUserRepository caheUserRepository)
    {
        this.caheUserRepository = caheUserRepository;
    }

    public CaheUser getPrincipal()
    {
        final User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final String mail = principal.getUsername();

        return caheUserRepository.findByMail(mail);
    }
}
