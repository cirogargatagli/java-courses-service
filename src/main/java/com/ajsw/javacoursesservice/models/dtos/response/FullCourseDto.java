package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;
import java.sql.Time;

public class FullCourseDto {

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
    public BigInteger price;

    @Getter
    @Setter
    public String tittle;

    @Getter
    @Setter
    public String description;

    @Getter
    @Setter
    public String imageURL;

    @Getter
    @Setter
    public int capacity;

    @Getter
    @Setter
    public InstructorDto instructor;

    @Getter
    @Setter
    public ActivityDto activity;

    @Getter
    @Setter
    public AddressDto address;

    @Getter
    @Setter
    public DayResponseDto day;

    @Getter
    @Setter
    public int reservesCount;
}
