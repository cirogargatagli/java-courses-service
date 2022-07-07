package com.ajsw.javacoursesservice.models.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.thoughtworks.qdox.model.expression.Add;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class CourseRequest {
    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    public Time startTime;

    @Getter
    @Setter
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    public Time endTime;

    @Getter
    @Setter
    public BigInteger price;

    @Getter
    @Setter
    public int idInstructor;

    @Getter
    @Setter
    public int idActivity;

    @Getter
    @Setter
    public AddressRequest address;

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
    public int idDay;
}
