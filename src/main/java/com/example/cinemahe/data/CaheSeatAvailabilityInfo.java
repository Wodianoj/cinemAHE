package com.example.cinemahe.data;

import com.example.cinemahe.model.CaheSeat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class CaheSeatAvailabilityInfo
{
    private Long seanceId;

    private Boolean available;

    private CaheSeat seat;
}
