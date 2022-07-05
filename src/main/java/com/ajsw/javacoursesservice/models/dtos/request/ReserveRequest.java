package com.ajsw.javacoursesservice.models.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class ReserveRequest {

    @Getter
    @Setter
    private int idReserve;

    @Getter
    @Setter
    public int idCourse;

    @Getter
    @Setter
    public int idClient;

    @Getter
    @Setter
    public int idPayment;

}
