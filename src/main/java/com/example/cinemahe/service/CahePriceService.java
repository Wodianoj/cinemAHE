package com.example.cinemahe.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CahePriceService
{
    public BigDecimal getPrice()
    {
        return new BigDecimal("25.00");
    }
}
