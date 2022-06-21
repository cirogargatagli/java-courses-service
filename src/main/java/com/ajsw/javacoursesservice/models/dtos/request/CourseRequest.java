package com.ajsw.javacoursesservice.models.dtos.request;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigInteger;
import java.sql.Time;

public class CourseRequest {
    public Time startTime;

    public Time endTime;

    public BigInteger price;

    public int idInstructor;

    public int idActivity;

    public int idAddress;

    public String tittle;

    public String description;

    public String imageURL;
}
