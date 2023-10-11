package com.sapient.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Field(type = FieldType.Keyword, name = "movie_name")
    private String movie_name;
    @Field(type = FieldType.Text, name = "auditorium_name")
    private String auditorium_name;
    @Field(type = FieldType.Keyword, name = "auditorium_id")
    private Integer auditorium_id;
    @Field(type = FieldType.Nested, name = "showtimes")
    private List<ShowTime> showtimes;
}
