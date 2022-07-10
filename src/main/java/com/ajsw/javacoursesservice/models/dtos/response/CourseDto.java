package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

public class CourseDto{
    @Getter
    @Setter
    public int idCourse;

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

    @Getter
    @Setter
    public DayResponseDto day;

    @Getter
    @Setter
    public int capacity;

    @Getter
    @Setter
    public int reservesCount;
}
