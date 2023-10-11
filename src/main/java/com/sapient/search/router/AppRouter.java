package com.sapient.search.router;

import com.sapient.search.handler.ShowSearchHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class AppRouter {

  @Bean
  public RouterFunction<ServerResponse> searchRoute(ShowSearchHandler showSearchHandler) {
    return (RouterFunction<ServerResponse>) RouterFunctions.route(
        GET("/v1/searchShowsByLocShowAndDate/{loc}")
                .and(acceptMediaType()),
        showSearchHandler::searchByLocAndMovieAndDate);
  }

  private static RequestPredicate acceptMediaType() {
    return accept(MediaType.APPLICATION_JSON);
  }
}
