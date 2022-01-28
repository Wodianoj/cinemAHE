package com.example.cinemahe.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PUBLIC;

@Data
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
@Builder(toBuilder = true)
public class CahePurchaseRequest
{
    /**
     * The six-digit BLIK payment code.
     */
    private String blik;

    /**
     * The uuid of the ticket request.
     */
    private String uuid;
}
