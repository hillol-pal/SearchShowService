package com.sapient.search.handler;

import com.sapient.search.model.Theater;
import com.sapient.search.service.impl.ShowSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class ShowSearchHandler {

    private final ShowSearchServiceImpl searchService;

    @Autowired
    public ShowSearchHandler(ShowSearchServiceImpl service) {
        this.searchService = service;
    }

    public Mono<ServerResponse> searchByLocAndMovieAndDate(ServerRequest serverRequest) {
        String location = serverRequest.pathVariable("loc");
        String movie = serverRequest.queryParam("movie").get();
        String dateJson = serverRequest.queryParam("date").get();

        Mono<List<Theater>> theaters = searchService.findByDateLocAndShow(LocalDate.parse(dateJson),location,movie).collectList();

        return theaters.flatMap(shows -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(shows));


    }


}
