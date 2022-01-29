package com.example.cinemahe.repository;

import com.example.cinemahe.form.CaheSeanceSearchForm;
import com.example.cinemahe.model.CaheSeance;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaheSeanceRepository extends CrudRepository<CaheSeance, Long>
{
    @Query("SELECT cs FROM CaheSeance cs")
    List<CaheSeance> search(@Param("searchForm") final CaheSeanceSearchForm searchForm);
}
