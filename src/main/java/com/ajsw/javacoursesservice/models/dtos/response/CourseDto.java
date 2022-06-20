package com.ajsw.javacoursesservice.models.dtos.response;

import com.ajsw.javacoursesservice.models.entities.Activity;
import com.ajsw.javacoursesservice.models.entities.Address;
import com.ajsw.javacoursesservice.models.entities.Instructor;
import com.ajsw.javacoursesservice.models.entities.Reserve;
import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

public class CourseDto {

    @Getter
    @Setter
    private int idCourse;

    @Getter
    @Setter
    private Date startTime;

    @Getter
    @Setter
    private Date endTime;

    @Getter
    @Setter
    private BigInteger price;

    @Getter
    @Setter
    private Instructor instructor;

    @Getter
    @Setter
    private Activity activity;

    @Getter
    @Setter
    private Address address;

    @Getter
    @Setter
    private List<Reserve> reserves;
}
