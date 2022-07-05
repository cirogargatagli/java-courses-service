package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

public class CourseResponseDto {
    @Getter
    @Setter
    public Time startTime;
    @Getter
    @Setter
    public Time endTime;
    @Getter
    @Setter
    public String tittle;
    @Getter
    @Setter
    public String imageURL;
}
