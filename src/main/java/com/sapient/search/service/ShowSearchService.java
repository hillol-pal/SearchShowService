package com.sapient.search.service;

import com.sapient.search.model.Theater;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface ShowSearchService {

    public Flux<Theater> findByDateLocAndShow(LocalDate date, String Location,String movie);
}
