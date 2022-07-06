package com.ajsw.javacoursesservice.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class ReserveResponseDto {
    @Getter
    @Setter
    private int idReserve;

    @Getter
    @Setter
    private Timestamp createdAt;

    @Getter
    @Setter
    private CourseResponseDto course;

    @Getter
    @Setter
    private PaymentReserveDto payment;

}
