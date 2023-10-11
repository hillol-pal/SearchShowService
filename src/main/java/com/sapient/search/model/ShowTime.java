package com.sapient.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowTime {

    @Field(type = FieldType.Text, name = "start_time")
    private String start_time;
    @Field(type = FieldType.Text, name = "end_time")
    private String end_time;

}
