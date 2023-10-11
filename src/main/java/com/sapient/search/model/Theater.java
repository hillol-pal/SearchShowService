package com.sapient.search.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "theaters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    @Id
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date, name = "date")
    private LocalDate date;
    @Field(type = FieldType.Keyword, name = "theaterName")
    private String theaterName;
    @Field(type = FieldType.Text, name = "address")
    private String address;
    @Field(type = FieldType.Text, name = "latitude")
    private String latitude;
    @Field(type = FieldType.Text, name = "longitude")
    private String longitude;
    @Field(type = FieldType.Keyword, name = "city")
    private String city;
    @Field(type = FieldType.Text, name = "company")
    private String company;
    @Field(type = FieldType.Nested, name = "shows")
    private List<Show> shows;
}
