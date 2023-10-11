package com.sapient.search.repository;

import com.sapient.search.model.Theater;
import org.springframework.data.elasticsearch.annotations.Query;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface ShowRepository extends ReactiveElasticsearchRepository<Theater, String> {

  @Query(
      "{\"constant_score\": {\"filter\": {\"bool\": { \"must\": [{\"term\": {\"city\": \"?0\" } },{\"term\": {\"date\": \"?1\" } },{\"nested\": {\"path\": \"shows\",\"query\": {\"bool\": {\"must\": [{\"match\": {\"shows.movie_name\": \"?2\"} } ] } }}}]}}}}")
  Flux<Theater> findAllTheatersByMovieUsingDateAndCity(String location, LocalDate date,String movie);
}
