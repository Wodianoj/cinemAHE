package com.example.cinemahe.data;

import com.example.cinemahe.model.CaheTicket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class CahePurchaseSummary
{
    /**
     * The number of tickets to be bought.
     */
    private Integer count;

    /**
     * The total price to be paid for the tickets.
     */
    private BigDecimal total;

    /**
     * The list of tickets created based on the ticket request.
     * These tickets will be bought if the client makes the payment.
     */
    private List<CaheTicket> tickets;
}
