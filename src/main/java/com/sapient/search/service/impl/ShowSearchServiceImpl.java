package com.sapient.search.service.impl;

import com.sapient.search.model.Theater;
import com.sapient.search.repository.ShowRepository;
import com.sapient.search.service.ShowSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Service
@Slf4j
public class ShowSearchServiceImpl implements ShowSearchService {

    private final ShowRepository reactiveRepo;

    @Autowired
    public ShowSearchServiceImpl(ShowRepository repo) {
        this.reactiveRepo = repo;
    }

    @Override
    public Flux<Theater> findByDateLocAndShow(LocalDate date, String location, String movie) {

        log.info("Date: {} AND Movie: {}",date,movie);
        return reactiveRepo.findAllTheatersByMovieUsingDateAndCity(location,date,movie);
    }
}
