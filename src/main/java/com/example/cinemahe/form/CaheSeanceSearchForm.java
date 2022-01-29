package com.example.cinemahe.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CaheSeanceSearchForm
{
    private final Long cinemaId;
    private final Long movieId;
}
