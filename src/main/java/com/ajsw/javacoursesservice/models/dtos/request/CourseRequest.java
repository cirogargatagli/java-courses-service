package com.ajsw.javacoursesservice.models.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.thoughtworks.qdox.model.expression.Add;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class CourseRequest {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-ddTHH:mm:ss")
    public Timestamp startTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-ddTHH:mm:ss")
    public Timestamp endTime;

    public BigInteger price;

    public int idInstructor;

    public int idActivity;

    public AddressRequest address;

    public String tittle;

    public String description;

    public String imageURL;
}
