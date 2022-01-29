package com.example.cinemahe.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CaheSeatSearchForm
{
    private final Long seanceId;
    private final Integer rowNumber;
}
