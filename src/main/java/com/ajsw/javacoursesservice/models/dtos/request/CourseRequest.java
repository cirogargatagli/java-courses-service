package com.ajsw.javacoursesservice.models.dtos.request;

import java.math.BigInteger;
import java.sql.Date;

public class CourseRequest {
    public Date startTime;

    public Date endTime;

    public BigInteger price;

    public int idInstructor;

    public int idActivity;

    public int idAddress;
}
